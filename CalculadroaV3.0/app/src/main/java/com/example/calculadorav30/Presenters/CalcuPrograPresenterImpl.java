package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalcuPrograInteractorimpl;
import com.example.calculadorav30.Interfaces.CalcuPrograInteractor;
import com.example.calculadorav30.Interfaces.CalcuPrograPresenter;
import com.example.calculadorav30.Interfaces.CalcuPrograView;

/**
 * The CalcuPrograPresenterImpl for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalcuPrograPresenter
 */
public class CalcuPrograPresenterImpl implements CalcuPrograPresenter {


    /**
     * view para obtener la vista
     * interactor para poder solicitar al modelo
     * factor para manejar un objeto de la clase numero
     * factMemory para manejar numero en memoria
     */
    private CalcuPrograView view;
    private CalcuPrograInteractor interactor;
    private String factor;

    /**
     * Metodo constructor de la clase cuando la vista solicita al presentador
     * @param view
     */
    public CalcuPrograPresenterImpl(CalcuPrograView view) {
        this.view = view;
        interactor=new CalcuPrograInteractorimpl(this);
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
            if(_operation.equals("decimal")){
                operateCastDeToBi(_factor1);
                operateCastDeToOc(_factor1);
                operateCastDeToHe(_factor1);
            }
            else if(_operation.equals("binary")){
                operateCastBiToDe(_factor1);
                operateCastBiToHe(_factor1);
                operateCastBiToOc(_factor1);
            }
            else if(_operation.equals("octal")){
                operateCastOcToDe(_factor1);
                operateCastOcToHe(_factor1);
                operateCastOcToBi(_factor1);
            }
            else if(_operation.equals("hexadecimal")){
                operateCastHeToBi(_factor1);
                operateCastHeToDe(_factor1);
                operateCastHeToOc(_factor1);
            }
        }
    }

    /**
     * Metodo que convierte de decimal a binario
     * @param _factor1 el numero decimal
     */
    @Override
    public void operateCastDeToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToBi(_factor1);
            showResultBinario(factor);
        }
    }

    /**
     * Metodo que convierte de decimal a octal
     * @param _factor1 el numero decimal
     */
    @Override
    public void operateCastDeToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToOc(_factor1);
            showResultOctal(factor);
        }
    }

    /**
     * Metodo que convierte de decimal a hexadecimal
     * @param _factor1 el numero decimal
     */
    @Override
    public void operateCastDeToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToHe(_factor1);
            showResultHedecimal(factor);
        }
    }

    /**
     * Metodo que convierte de binario a decimal
     * @param _factor1 el numero binario
     */
    @Override
    public void operateCastBiToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastBiToDe(_factor1);
            showResultDecimal(factor);
        }
    }

    /**
     * Metodo que convierte de binario a octal
     * @param _factor1 el numero binario
     */
    @Override
    public void operateCastBiToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToBi(_factor1);
            showResultOctal(factor);
        }
    }

    /**
     * Metodo que convierte de binario a hexadecimal
     * @param _factor1 el numero binario
     */
    @Override
    public void operateCastBiToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastBiToHe(_factor1);
            showResultHedecimal(factor);
        }
    }

    /**
     * Metodo que convierte de octal a decimal
     * @param _factor1 el numero octal
     */
    @Override
    public void operateCastOcToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToDe(_factor1);
            showResultDecimal(factor);
        }
    }

    /**
     * Metodo que convierte de octal a binario
     * @param _factor1 el numero octal
     */
    @Override
    public void operateCastOcToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToBi(_factor1);
            showResultBinario(factor);
        }
    }

    /**
     * Metodo que convierte de octal a hexadecimal
     * @param _factor1 el numero octal
     */
    @Override
    public void operateCastOcToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToHe(_factor1);
            showResultHedecimal(factor);
        }
    }

    /**
     * Metodo que convierte de hexadecimal a decimal
     * @param _factor1 el numero octal
     */
    @Override
    public void operateCastHeToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToDe(_factor1);
            showResultDecimal(factor);
        }
    }

    /**
     * Metodo que convierte de hexadecimal a octal
     * @param _factor1 el numero hexadecimal
     */
    @Override
    public void operateCastHeToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToOc(_factor1);
            showResultOctal(factor);
        }
    }

    /**
     * Metodo que convierte de hexadecimal a binario
     * @param _factor1 el numero hexadecimal
     */
    @Override
    public void operateCastHeToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToBi(_factor1);
            showResultBinario(factor);
        }
    }

    /**
     * Este metodo envia el decimal a la Vista
     */
    @Override
    public void showResultDecimal(String _result) {
        if (factor != null)
            view.showResultDecimal(_result);
    }

    /**
     * Este metodo envia el hexadecimal a la Vista
     */
    public void showResultHedecimal(String _result) {
        if (factor != null)
            view.showResultHedecimal(_result);
    }

    /**
     * Este metodo envia el binario a la Vista
     */
    public void showResultBinario(String _result) {
        if (factor != null)
            view.showResultBinario(_result);
    }

    /**
     * Este metodo envia el octal a la Vista
     */
    public void showResultOctal(String _result) {
        if (factor != null)
            view.showResultOctal(_result);
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


    /**
     * Metodos Getter and Setter
     */
    public CalcuPrograView getView() {
        return view;
    }

    public void setView(CalcuPrograView view) {
        this.view = view;
    }

    public CalcuPrograInteractor getInteractor() {
        return interactor;
    }

    public void setInteractor(CalcuPrograInteractor interactor) {
        this.interactor = interactor;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

}
