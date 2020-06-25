package com.example.calculadorav30.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculadorav30.Interfaces.CalcuCientiPresenter;
import com.example.calculadorav30.Interfaces.CalcuCientiView;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;
import com.example.calculadorav30.Presenters.CalcuCientiPresenterImpl;
import com.example.calculadorav30.Presenters.CalculadoraPresenterImpl;
import com.example.calculadorav30.R;

/**
 * The CalculadoraCientifica Activity for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta es la Vista que mira el usuario
 */
public class CalculadoraCientifica extends AppCompatActivity implements CalcuCientiView {

    /**
     * EditText para ver la expresion matematica y el resultado
     */
    private EditText txtResult;
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
    public CalcuCientiPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cientifica);

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

        presenter=new CalcuCientiPresenterImpl(this);
    }


    //region Botones de Operaciones Aritmeticas
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
    //endregion

    //region Botones de Numeros
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
    public void setEight(View view) {
        setCheckNum(btn8.getText().toString()); }

    /**
     * Este metodo obtiene el valor de tipo string="9"
     * @param view
     */
    public void setNine(View view) { setCheckNum(btn9.getText().toString()); }

    /**
     * Este metodo llama al metodo setCheckNumFloat para verificar si el factor entero se convierte a flotante
     * @param view
     */
    public void setPoint(View view) {
        setCheckNumFloat(factor1);
        btnPoint.setEnabled(false);
    }
    //endregion

    //region Botones Funcionales
    /**
     * Este metodo solicita que se realize la operacion
     * @param view
     */
    public void equal(View view) {
        checkDoOperation();
        activateOperator=false;
        operation="";
    }

    public void graph(View view) {
        //checkFactors("erase","");
        Intent miIntent=new Intent(CalculadoraCientifica.this,CalculadoraGraficadora.class);
        Bundle miBundle=new Bundle();
        miBundle.putString("Operacion",operation);
        miBundle.putString("Angulo",factor1);

        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    public void seno(View view) {
        checkFactors("seno","sen");
    }

    public void coseno(View view) { checkFactors("coseno","cos");  }

    public void logartihm(View view) { checkFactors("loga","log");  }

    public void pow(View view) { checkFactors("pow","^"); }

    public void module(View view) { checkFactors("module","%"); }
    //endregion

    //region Metodos para Mostrar
    /**
     * Este metodo muestra la expresion matematica
     */
    public void showNumber(){
        txtResult.setText(expression);
    }

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
    //endregion

    //region Metodos para Reiniciar Campos
    /**
     * Este metodo resetea la expresion matematica
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
    //endregion

    //region Metodos para Validar Inputs
    public void checkFactors(String _operation,String _charOperation){
        activateOperator=true;
        operation=_operation;
        btnPoint.setEnabled(true);
        expression=expression.concat(_charOperation);
        stateSign=false;
        showNumber();
    }

    /**
     * Este Metodo Concatena cada factor entero o flotante y tambien concatena la expression
     * @param factor
     */
    @Override
    public void setCheckNum(String factor) {
        if(operation.equals("seno") || operation.equals("coseno") || operation.equals("loga")){
            if (factor1 == null || (!stateSign && activateOperator == false)) {
                if (!stateSign) {
                    factor1 = factor;
                    stateSign = true;
                    expression = factor1;
                } else if (factor1 == null) {
                    factor1 = factor1.concat(factor);
                    expression = factor1;
                }
            } else if (factor1 != null && activateOperator == true && checkNumFloat == true) {
                factor1 = factor1.concat(factor);
                expression = expression.concat(factor);
            }

        }else {
            if (factor1 == null || (!stateSign && activateOperator == false)) {
                if (!stateSign) {
                    factor1 = factor;
                    stateSign = true;
                    expression = factor1;
                } else if (factor1 == null) {
                    factor1 = factor1.concat(factor);
                    expression = factor1;
                }
            } else if (factor1 != null && activateOperator == false && checkNumFloat == true) {
                factor1 = factor1.concat(factor);
                expression = expression.concat(factor);
            } else if (factor2 == null || (activateOperator == true && !stateSign)) {
                if (!stateSign && factor2 == null) {
                    factor2 = factor;
                    //stateSign=true;
                } else if (activateOperator == true) {
                    factor2 = factor2.concat(factor);
                }

                //factor2=factor;
                expression = expression.concat(factor);
            } else if (factor2 != null && activateOperator == true) {
                factor2 = factor2.concat(factor);
                expression = expression.concat(factor);
            }
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
    //endregion

    //region Metodos para solicitar operaciones al presentador
    /**
     * Este metodo hace una solicitud de realizar una operacion matematica al Presentador
     */
    @Override
    public void checkDoOperation() { presenter.checkDoOperation(factor1, factor2,activateOperator,operation); }


    //endregion

    //region Botones para navegar entre Activitys
    public void prevActivity(View view) {
        Intent miIntent=new Intent(CalculadoraCientifica.this,Calculadora.class);
        startActivity(miIntent);
    }

    public void nextActivity(View view) {
        Intent miIntent=new Intent(CalculadoraCientifica.this,CalculadoraProgramador.class);
        startActivity(miIntent);
    }
    //endregion


}
