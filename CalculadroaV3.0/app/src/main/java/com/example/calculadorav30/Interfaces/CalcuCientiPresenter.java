package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

public interface CalcuCientiPresenter {

    void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation);

    void operateSen(String _angle);

    void operateCos(String _angle);

    void operateLoga(String _arg);

    void showResult(String _result);

    void showMessageError(String _message);
}
