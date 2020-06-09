package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalculadoraInteractorImpl;
import com.example.calculadorav30.Interactors.Numero;
import com.example.calculadorav30.Interfaces.OpeAritmeticaInteractor;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;
import com.example.calculadorav30.Interfaces.CalculadoraView;

/**
 * The CalculadoraPresenterImple for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Clase implementa la interface CalculadoraPresenter
 */

public class CalculadoraPresenterImpl implements OpeAritmeticaPresenter {

    private CalculadoraView view;
    private OpeAritmeticaInteractor interactor;
    private Numero factor;

    /**
     * Metodo constructor de la clase cuando la vista solicita al presentador
     * @param view
     */
    public CalculadoraPresenterImpl(CalculadoraView view) {
        this.view = view;
        interactor=new CalculadoraInteractorImpl(this);
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
     * @param _factor1
     * @param _factor2
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

    @Override
    public void operatePow(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operatePow(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    @Override
    public void operateRadical(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateRadical(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    @Override
    public void operatePercent(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateMultiply(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    /**
     * Este metodo envia la respuesta a la Vista
     */
    @Override
    public void showResult(String _result) {
        if (factor != null) {
            view.showResult(_result);
        }
    }

    @Override
    public void showMessageError(String _message) {
        if (view != null) {
            view.showMessageError(_message);
        }
    }

}
