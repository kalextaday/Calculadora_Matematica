package com.example.calculadorav2.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculadorav2.Interfaces.CalculadoraPresenter;
import com.example.calculadorav2.Interfaces.CalculadoraView;
import com.example.calculadorav2.Presenters.CalculadoraPresenterImpl;
import com.example.calculadorav2.R;

/**
 * The Calculadora Activity for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta es la Vista que mira el usuario
 */
public class Calculadora extends AppCompatActivity implements CalculadoraView{

    /**
     * Watch me document this code
     */
    /**
     * EditText para ver la expresion matematica y el resultado
     */
    private EditText txtResult;
    /**
     * Button para extraer las vistas de calculadora.xml
     */
    private Button btn1,btn2,btn3,
            btn4,btn5,btn6,btn7,
            btn8,btn9,btn0;
    /**
     * Variables de tipo String donde guardo los factores, tipo de operacion y la expresion total
     */
    private String factor1,factor2,operation,expression;
    /**
     * Variables de tipo boolean para comprobar si una operadcion esta activa
     */
    private boolean activateOperator,checkNumFloat;
    /**
     * Variables de tipo CalculadoraPresenter para la comunicacion con el presentador
     */
    private CalculadoraPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        factor1=null;
        factor2=null;
        checkNumFloat=activateOperator=false;
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

        presenter=new CalculadoraPresenterImpl(this);

    }

    /**
     * Este Metodo Concatena cada factor entero o flotante y tambien concatena la expression
     * @param factor
     */
    @Override
    public void setCheckNum(String factor) {
        if(factor1==null){
            factor1=factor;
            expression=factor;
        }
        else if(factor1!=null && activateOperator==false && checkNumFloat==true){
            factor1=factor1.concat(factor);
            expression=expression.concat(factor);
        }
        else if(factor2==null && activateOperator==true){
            factor2=factor;
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
    public void checkDoOperation() {
        if(factor1!=null && factor2!=null && activateOperator==true){
            if(operation.equals("plus"))
                presenter.operatePlus(factor1,factor2);
            if(operation.equals("substraction"))
                presenter.operateSubstraction(factor1,factor2);
            if(operation.equals("multiply"))
                presenter.operateMultiply(factor1,factor2);
            if(operation.equals("divide"))
                presenter.operateDivide(factor1,factor2);
        }
    }

    @Override
    public void reset() {

    }

    /**
     * Este metodo muestra en el EditText el resultado
     * @param result
     */
    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    /**
     * Este metodo activa el estado de la operacion en Suma
     * @param view
     */
    public void plus(View view) {
        activateOperator=true;
        operation="plus";
        expression=expression.concat("+");
        showNumber();
    }

    /**
     * Este metodo activa el estado de la operacion en Resta
     * @param view
     */
    public void substraction(View view) {
        activateOperator=true;
        operation="substraction";
        expression=expression.concat("-");
        showNumber();
    }

    /**
     * Este metodo activa el estado de la operacion en Multiplicacion
     * @param view
     */
    public void multiply(View view) {
        activateOperator=true;
        operation="multiply";
        expression=expression.concat("x");
        showNumber();
    }

    /**
     * Este metodo activa el estado de la operacion en Division
     * @param view
     */
    public void divide(View view) {
        activateOperator=true;
        operation="divide";
        expression=expression.concat("/");
        showNumber();
    }

    /**
     * Este metodo solicita que se realize la operacion
     * @param view
     */
    public void equal(View view) {
        checkDoOperation();
        activateOperator=false;
        operation="";
    }


    /**
     * Este metodo llama al metodo setCheckNumFloat para verificar si el factor entero se convierte a flotante
     * @param view
     */
    public void setPoint(View view) {
        setCheckNumFloat(factor1);
    }

    public void mSubstraction(View view) {

    }

    public void mPlus(View view) {
    }

    /**
     * Este metodo obtiene el valor de tipo string="0"
     * @param view
     */
    public void setZero(View view) {
        setCheckNum(btn0.getText().toString());
    }

    public void delete(View view) {
    }

    /**
     * Este metodo obtiene el valor de tipo string="3"
     * @param view
     */
    public void setThree(View view) {
        setCheckNum(btn3.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="6"
     * @param view
     */
    public void setSix(View view) {
        setCheckNum(btn6.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="9"
     * @param view
     */
    public void setNine(View view) {
        setCheckNum(btn9.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="2"
     * @param view
     */
    public void setTwo(View view) {
        setCheckNum(btn2.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="5"
     * @param view
     */
    public void setFive(View view) {
        setCheckNum(btn5.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="8"
     * @param view
     */
    public void setEight(View view) {
        setCheckNum(btn8.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="4"
     * @param view
     */
    public void setFour(View view) {
        setCheckNum(btn4.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="1"
     * @param view
     */
    public void setOne(View view) {
        setCheckNum(btn1.getText().toString());
    }

    /**
     * Este metodo obtiene el valor de tipo string="7"
     * @param view
     */
    public void setSeven(View view) {
        setCheckNum(btn7.getText().toString());
    }

    /**
     * Este metodo muestra la expresion matematica
     */
    public void showNumber(){
        txtResult.setText(expression);
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
    }
}
