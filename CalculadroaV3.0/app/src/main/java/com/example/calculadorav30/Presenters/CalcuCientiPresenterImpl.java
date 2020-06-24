package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.CalcuCientiInteractorImpl;
import com.example.calculadorav30.Interactors.Numero;
import com.example.calculadorav30.Interfaces.CalcuCientiInteractor;
import com.example.calculadorav30.Interfaces.CalcuCientiPresenter;
import com.example.calculadorav30.Interfaces.CalcuCientiView;

public class CalcuCientiPresenterImpl implements CalcuCientiPresenter {

    private CalcuCientiView view;
    private CalcuCientiInteractor interactor;
    private Numero factor;

    public CalcuCientiPresenterImpl(CalcuCientiView view) {
        this.view = view;
        interactor=new CalcuCientiInteractorImpl(this);
    }

    @Override
    public void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation) {
        /*
        if(_factor1!=null && _factor2!=null && _activateOperator==true){
            if(_operation.equals("seno"))
                operateSen(_factor1);
            else if(_operation.equals("coseno"))
                operateCos(_factor1);
            else if(_operation.equals("loga"))
                operateLoga(_factor1);
        }
        */
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

    @Override
    public void operateSen(String _angle) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateSen(_angle);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    @Override
    public void operateCos(String _angle) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateCos(_angle);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

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

    public void operateModule(String _factor1, String _factor2) {
        String value="";
        if (interactor != null) {
            factor=interactor.operateModule(_factor1, _factor2);
            value=Double.toString(factor.getValue());
            showResult(value);
        }
    }

    @Override
    public void showResult(String _result) {
        if (factor != null)
            view.showResult(_result);
    }

    @Override
    public void showMessageError(String _message) {
        if (view != null)
            view.showMessageError(_message);
    }
}
