package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

/**
 * The OpeAritmeticaPresenter for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Interface que sera implementada por CalculadoraPresenterImpl
 */
public interface OpeAritmeticaPresenter {

    void checkDoOperation(String _factor1, String _factor2, boolean _activateOperator, String _operation);

    void operatePlus(String _factor1, String _factor2);

    void operateSubstraction(String _factor1, String _factor2);

    void operateMultiply(String _factor1, String _factor2);

    void operateDivide(String _factor1, String _factor2);

    void operatePow(String _factor1, String _factor2);

    void operateRadical(String _factor1, String _factor2);

    void operateModule(String _factor1, String _factor2);

    void operateFactMemory(String _factor1,String _operate);

    void operateFactorial(String _factor1);

    void operateMrecover();

    void showResult(String _result);

    void showMessageError(String _message);
}
