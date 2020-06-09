package com.example.calculadorav30.Interfaces;

/**
 * The CalculadoraPresenter for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Interface que sera implementada por CalculadoraPresenterImpl
 */
public interface CalculadoraPresenter {

    void operatePlus(String _factor1, String _factor2);

    void operateSubstraction(String _factor1, String _factor2);

    void operateMultiply(String _factor1, String _factor2);

    void operateDivide(String _factor1, String _factor2);

    void showResult(String _result);

    void showMessageError(String _message);
}
