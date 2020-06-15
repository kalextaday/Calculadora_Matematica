package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

public interface CalcuPrograPresenter {

    void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation);

    void operateCastDeToBi(String _factor1);

    void operateCastDeToOc(String _factor1);

    void operateCastDeToHe(String _factor1);

    void operateCastBiToDe(String _factor1);

    void operateCastBiToOc(String _factor1);

    void operateCastBiToHe(String _factor1);

    void operateCastOcToDe(String _factor1);

    void operateCastOcToBi(String _factor1);

    void operateCastOcToHe(String _factor1);

    void operateCastHeToDe(String _factor1);

    void operateCastHeToOc(String _factor1);

    void operateCastHeToBi(String _factor1);

    void showResult(String _result);

    void showMessageError(String _message);
}
