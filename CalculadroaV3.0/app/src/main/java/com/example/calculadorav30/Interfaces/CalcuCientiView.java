package com.example.calculadorav30.Interfaces;

/**
 * The CalcuCientiView for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Interface que sera implementada por CalculadoraCientifica
 */
public interface CalcuCientiView {

    void setCheckNum(String factor);

    void setCheckNumFloat(String factor);

    void checkDoOperation();

    void showResult(String _result);

    void showMessageError(String _message);
}
