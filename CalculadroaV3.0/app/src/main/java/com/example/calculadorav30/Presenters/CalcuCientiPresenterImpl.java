package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalcuCientiInteractorImpl;
import com.example.calculadorav30.Interactors.Numero;
import com.example.calculadorav30.Interfaces.CalcuCientiInteractor;
import com.example.calculadorav30.Interfaces.CalcuCientiPresenter;
import com.example.calculadorav30.Interfaces.CalcuCientiView;

/**
 * The CalcuCientiPresenterImpl for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalcuCientiPresenter
 */
public class CalcuCientiPresenterImpl implements CalcuCientiPresenter {


    /**
     * view para obtener la vista
     * interactor para poder solicitar al modelo
     * factor para manejar un objeto de la clase numero
     * factMemory para manejar numero en memoria
     */

    private CalcuCientiView view;
    private CalcuCientiInteractor interactor;
    private Numero factor;

    /**
     * Metodo constructor de la clase cuando la vista solicita al presentador
     * @param view
     */
    public CalcuCientiPresenterImpl(CalcuCientiView view) {
        this.view = view;
        interactor=new CalcuCientiInteractorImpl(this);
    }

    /**
     * Metodo para verificar la operacion a realizarse
     * @param _factor1 el primer numero
     * @param _factor2 el segundo numero
     * @param _activateOperator el estado de una operacion
     * @param _operation la operacion a realizarse
     */
    @Override
    public void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation) {
        if(_factor1!=null && _activateOperator==true){
            if(_operation.equals("seno"))
                operateSen(_factor1);
            else if(_operation.equals("coseno"))
                operateCos(_factor1);
            else if(_operation.equals("loga"))
                operateLoga(_factor1);
            else if(_operation.equals("module"))
                operateModule(_factor1,_factor2);
        }
    }

    /**
     * Metodo que calcula el seno
     * @param _angle numero en grados
     */
    @Override
    public void operateSen(String _angle) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateSen(_angle);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Metodo que calcula el coseno
     * @param _angle numero en grados
     */
    @Override
    public void operateCos(String _angle) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateCos(_angle);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Metodo que calcula el logaritmo
     * @param _arg a ser calculado para el logaritmo
     */
    @Override
    public void operateLoga(String _arg) {
        String value="";
        if (interactor != null && Integer.parseInt(_arg)>0) {
            factor=interactor.operateLoga(_arg);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
        if(Integer.parseInt(_arg)<=0){
            showResult("Ingresa positivos");
        }
    }

    /**
     * Metodo que calcula el modulo
     * @param _factor1 el numero
     * @param _factor2 el numero 2
     */
    public void operateModule(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateModule(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo envia la respuesta a la Vista
     */
    @Override
    public void showResult(String _result) {
        if (factor != null)
            view.showResult(_result);
    }

    /**
     * Este metodo envia un mesaje de error a la Vista
     */
    @Override
    public void showMessageError(String _message) {
        if (view != null)
            view.showMessageError(_message);
    }

    /**
     * Metodos Getter and Setter
     */
    public CalcuCientiView getView() {
        return view;
    }

    public void setView(CalcuCientiView view) {
        this.view = view;
    }

    public CalcuCientiInteractor getInteractor() {
        return interactor;
    }

    public void setInteractor(CalcuCientiInteractor interactor) {
        this.interactor = interactor;
    }

    public Numero getFactor() {
        return factor;
    }

    public void setFactor(Numero factor) {
        this.factor = factor;
    }

}
