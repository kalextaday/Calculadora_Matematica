package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalculadoraInteractorImpl;
import com.example.calculadorav30.Interactors.Numero;
import com.example.calculadorav30.Interfaces.OpeAritmeticaInteractor;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;
import com.example.calculadorav30.Interfaces.CalculadoraView;

/**
 * The CalculadoraPresenterImple for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalculadoraPresenter
 */

public class CalculadoraPresenterImpl implements OpeAritmeticaPresenter {

    private CalculadoraView view;
    private OpeAritmeticaInteractor interactor;
    private Numero factor;
    private Numero factMemory;

    /**
     * Metodo constructor de la clase cuando la vista solicita al presentador
     * @param view
     */
    public CalculadoraPresenterImpl(CalculadoraView view) {
        factMemory=new Numero(0.0);
        this.view = view;
        interactor=new CalculadoraInteractorImpl(this);

    }

    @Override
    public void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation) {
        if(_factor1!=null && _factor2!=null && _activateOperator==true){
            if(_operation.equals("plus"))
                operatePlus(_factor1,_factor2);
            else if(_operation.equals("substraction"))
                operateSubstraction(_factor1,_factor2);
            else if(_operation.equals("multiply"))
                operateMultiply(_factor1,_factor2);
            else if(_operation.equals("divide"))
                operateDivide(_factor1,_factor2);
            else if(_operation.equals("pow"))
                operatePow(_factor1,_factor2);
            else if(_operation.equals("radical"))
                operateRadical(_factor1,_factor2);
            else if(_operation.equals("module"))
                operateModule(_factor1,_factor2);
        }
    }

    /**
     * Este metodo llama al metodo operatePlus del Modelo o Interactor
     * @param _factor1
     * @param _factor2
     */
    @Override
    public void operatePlus(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operatePlus(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo llama al metodo operateSubstraction del Modelo o Interactor
     * @param _factor1
     * @param _factor2
     */
    @Override
    public void operateSubstraction(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateSubstraction(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo llama al metodo operateMultiply del Modelo o Interactor
     * @param _factor1
     * @param _factor2
     */
    @Override
    public void operateMultiply(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateMultiply(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo llama al metodo operateDivide del Modelo o Interactor
     * @param _factor1 es el numerador
     * @param _factor2 es el denominador
     */
    @Override
    public void operateDivide(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateDivide(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo realiza la potencia de con cualquier base y cualquier exponente
     * @param _factor1 es la base
     * @param _factor2 es el exponente
     */
    @Override
    public void operatePow(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operatePow(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo realiza la raiz de con cualquier indice y cualquier radicando
     * @param _factor1 es el indice
     * @param _factor2 es el radicando
     */
    @Override
    public void operateRadical(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateRadical(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo calcula el modulo
     * @param _factor1 es el primer parametro
     * @param _factor2 es el segundo parametro
     */
    @Override
    public void operateModule(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateModule(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo realiza la operacion sobre el numero en memoria
     * @param _factor
     * @param _operate
     */
    @Override
    public void operateFactMemory(String _factor,String _operate) {
        String value="";
        String valueFactMemory=Double.toString(factMemory.getValue());
        if (interactor != null) {
            if(_operate.equals("plus"))
                factMemory=interactor.operatePlus(valueFactMemory, _factor);
            else if (_operate.equals("substraction"))
                factMemory=interactor.operateSubstraction(valueFactMemory, _factor);
        }
    }

    /**
     * Este metodo recupera el numero en memoria
     */
    @Override
    public void operateMrecover() {
        showResult(Double.toString(factMemory.getValue()));
    }

    /**
     * Este metodo envia la respuesta a la Vista
     */
    @Override
    public void showResult(String _result) {
        if (factor != null)
            view.showResult(_result);
        else if(factMemory != null)
            view.showResult(_result);
    }

    /**
     * Este metodo envia un mesaje de error a la Vista
     */
    @Override
    public void showMessageError(String _message) {
        if (view != null) {
            view.showMessageError(_message);
        }
    }

    public CalculadoraView getView() {
        return view;
    }

    public void setView(CalculadoraView view) {
        this.view = view;
    }

    public OpeAritmeticaInteractor getInteractor() {
        return interactor;
    }

    public void setInteractor(OpeAritmeticaInteractor interactor) {
        this.interactor = interactor;
    }

    public Numero getFactor() {
        return factor;
    }

    public void setFactor(Numero factor) {
        this.factor = factor;
    }

    public Numero getFactMemory() {
        return factMemory;
    }

    public void setFactMemory(Numero factMemory) {
        this.factMemory = factMemory;
    }
}
