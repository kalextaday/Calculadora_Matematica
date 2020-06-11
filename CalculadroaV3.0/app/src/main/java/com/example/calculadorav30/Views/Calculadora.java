package com.example.calculadorav30.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;
import com.example.calculadorav30.Interfaces.CalculadoraView;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;
import com.example.calculadorav30.Presenters.CalculadoraPresenterImpl;
import com.example.calculadorav30.R;

/**
 * The Calculadora Activity for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta es la Vista que mira el usuario
 */
public class Calculadora extends AppCompatActivity implements CalculadoraView{

    /**
     * EditText para ver la expresion matematica y el resultado
     */
    EditText txtResult;
    /**
     * Button para extraer las vistas de calculadora.xml
     */
    public Button btn1,btn2,btn3,
            btn4,btn5,btn6,btn7,
            btn8,btn9,btn0,btnPoint;
    /**
     * Variables de tipo String donde guardo los factores, tipo de operacion y la expresion total
     */
    private String factor1,factor2,operation,expression;
    /**
     * Variables de tipo boolean para comprobar si una operadcion esta activa
     */
    private boolean activateOperator,checkNumFloat,stateSign;
    /**
     * Variables de tipo CalculadoraPresenter para la comunicacion con el presentador
     */
    public OpeAritmeticaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        factor1=null;
        factor2=null;
        checkNumFloat=activateOperator=stateSign=false;
        expression=operation="";

        txtResult=(EditText) findViewById(R.id.txtResult);
        btn1=(Button) findViewById(R.id.btnNumOne);
        btn2=(Button) findViewById(R.id.btnNumTwo);
        btn3=(Button) findViewById(R.id.btnNumThree);
        btn4=(Button) findViewById(R.id.btnNumFour);
        btn5=(Button) findViewById(R.id.btnNumFive);
        btn6=(Button) findViewById(R.id.btnNumSix);
        btn7=(Button) findViewById(R.id.btnNumSeven);
        btn8=(Button) findViewById(R.id.btnNumEight);
        btn9=(Button) findViewById(R.id.btnNumNine);
        btn0=(Button) findViewById(R.id.btnNumZero);
        btnPoint=(Button) findViewById(R.id.btnPoint);

        presenter=new CalculadoraPresenterImpl(this);

    }

    /**
     * Este metodo muestra la expresion matematica
     */
    public void reset(View view) {
        initialize();
    }

    /**
     * Este metodo inicializa los factores a null, la expresion y operacion=""
     */
    public void initialize(){
        factor1=null;
        factor2=null;
        checkNumFloat=activateOperator=false;
        expression=operation="";
        txtResult.setText("");
        btnPoint.setEnabled(true);
        stateSign=false;
    }

    /**
     * Este Metodo Concatena cada factor entero o flotante y tambien concatena la expression
     * @param factor
     */
    @Override
    public void setCheckNum(String factor) {
        if(factor1==null || (!stateSign && activateOperator==false)){
            if(!stateSign){
                factor1=factor;
                stateSign=true;
                expression=factor1;
            }
            else if(factor1==null){
                factor1=factor1.concat(factor);
                expression=factor1;
            }
        }
        else if(factor1!=null && activateOperator==false && checkNumFloat==true){
            factor1=factor1.concat(factor);
            expression=expression.concat(factor);
        }
        else if(factor2==null || (activateOperator==true && !stateSign)){
            if(!stateSign && factor2==null){
                factor2=factor;
                //stateSign=true;
            }
            else if(activateOperator==true){
                factor2=factor2.concat(factor);
            }

            //factor2=factor;
            expression=expression.concat(factor);
        }
        else if(factor2!=null && activateOperator==true){
            factor2=factor2.concat(factor);
            expression=expression.concat(factor);
        }
        checkNumFloat=true;
        showNumber();
    }

    /**
     * Este metodo verifica si el numero ingresado pertenece a un flotante
     * @param factor
     */
    @Override
    public void setCheckNumFloat(String factor) {
        if(factor!=null && activateOperator==false){
            factor1=factor1.concat(".");
        }else{
            factor2=factor2.concat(".");
        }
        expression=expression.concat(".");
        showNumber();
    }

    /**
     * Este metodo hace una solicitud de realizar una operacion matematica al Presentador
     */
    @Override
    public void checkDoOperation() { presenter.checkDoOperation(factor1, factor2,activateOperator,operation); }

    @Override
    public void showMessageError(String _message) {
        txtResult.setText(_message);
    }

    /**
     * Este metodo muestra en el EditText el resultado
     * @param _result
     */
    @Override
    public void showResult(String _result) {
        txtResult.setText(_result);
    }

    /**
     * Este metodo activa el estado de la operacion en Suma
     * @param view
     */
    public void plus(View view) { checkFactors("plus","+"); }

    /**
     * Este metodo activa el estado de la operacion en Resta
     * @param view
     */
    public void substraction(View view) {
        if(!stateSign){
            setCheckNum("-");
        }else{
            checkFactors("substraction","-");
        }
    }

    /**
     * Este metodo activa el estado de la operacion en Multiplicacion
     * @param view
     */
    public void multiply(View view) { checkFactors("multiply","x"); }

    /**
     * Este metodo activa el estado de la operacion en Division
     * @param view
     */
    public void divide(View view) { checkFactors("divide","/"); }

    /**
     * Este metodo solicita que se realize la operacion
     * @param view
     */
    public void equal(View view) {
        checkDoOperation();
        activateOperator=false;
        operation="";
    }

    public void mRecover(View view) {
        presenter.operateMrecover();
    }

    public void mSubstraction(View view) {
        presenter.operateFactMemory(txtResult.getText().toString(),"substraction");
    }

    public void mPlus(View view) {
        presenter.operateFactMemory(txtResult.getText().toString(),"plus");
    }

    /**
     * Este metodo llama al metodo setCheckNumFloat para verificar si el factor entero se convierte a flotante
     * @param view
     */
    public void setPoint(View view) {
        setCheckNumFloat(factor1);
        btnPoint.setEnabled(false);
    }

    /**
     * Este metodo obtiene el valor de tipo string="0"
     * @param view
     */
    public void setZero(View view) { setCheckNum(btn0.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="1"
     * @param view
     */
    public void setOne(View view) { setCheckNum(btn1.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="2"
     * @param view
     */
    public void setTwo(View view) { setCheckNum(btn2.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="3"
     * @param view
     */
    public void setThree(View view) { setCheckNum(btn3.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="4"
     * @param view
     */
    public void setFour(View view) { setCheckNum(btn4.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="5"
     * @param view
     */
    public void setFive(View view) { setCheckNum(btn5.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="6"
     * @param view
     */
    public void setSix(View view) { setCheckNum(btn6.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="7"
     * @param view
     */
    public void setSeven(View view) { setCheckNum(btn7.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="8"
     * @param view
     */
    public void setEight(View view) { setCheckNum(btn8.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="9"
     * @param view
     */
    public void setNine(View view) { setCheckNum(btn9.getText().toString()); }

    /**
     * Este metodo muestra la expresion matematica
     */
    public void showNumber(){
        txtResult.setText(expression);
    }

    public void pow(View view) { checkFactors("pow","^"); }

    public void radical(View view) { checkFactors("radical","√"); }

    public void module(View view) { checkFactors("module","%"); }

    public void checkFactors(String _operation,String _charOperation){
        activateOperator=true;
        operation=_operation;
        btnPoint.setEnabled(true);
        expression=expression.concat(_charOperation);
        stateSign=false;
        showNumber();
    }
}

