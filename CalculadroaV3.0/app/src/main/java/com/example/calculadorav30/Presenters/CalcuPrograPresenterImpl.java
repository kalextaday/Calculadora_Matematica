package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalcuPrograInteractorimpl;
import com.example.calculadorav30.Interfaces.CalcuPrograInteractor;
import com.example.calculadorav30.Interfaces.CalcuPrograPresenter;
import com.example.calculadorav30.Interfaces.CalcuPrograView;

public class CalcuPrograPresenterImpl implements CalcuPrograPresenter {

    private CalcuPrograView view;
    private CalcuPrograInteractor interactor;
    private String factor;

    public CalcuPrograPresenterImpl(CalcuPrograView view) {
        this.view = view;
        interactor=new CalcuPrograInteractorimpl(this);
    }

    @Override
    public void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation) {
        if(_factor1!=null && _factor2!=null && _activateOperator==true){
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

    @Override
    public void operateCastDeToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToBi(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastDeToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToOc(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastDeToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToHe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastBiToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastBiToDe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastBiToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastDeToBi(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastBiToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastBiToHe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastOcToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToDe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastOcToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToBi(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastOcToHe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastOcToHe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastHeToDe(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToDe(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastHeToOc(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToOc(_factor1);
            showResult(factor);
        }
    }

    @Override
    public void operateCastHeToBi(String _factor1) {
        if (interactor != null) {
            factor=interactor.operateCastHeToBi(_factor1);
            showResult(factor);
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
        if (view != null) {
            view.showMessageError(_message);
        }
    }
}
