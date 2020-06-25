package com.example.calculadorav30.Interfaces;

/**
 * The CalcuPrograView for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Interface que sera implementada por CalculadoraProgramador
 */
public interface CalcuPrograView {

    void setCheckNum(String factor);

    void setCheckNumFloat(String factor);

    void checkDoOperation();

    void showResultDecimal(String _result);

    void showResultHedecimal(String _result);

    void showResultBinario(String _result);

    void showResultOctal(String _result);

    void showMessageError(String _message);
}
