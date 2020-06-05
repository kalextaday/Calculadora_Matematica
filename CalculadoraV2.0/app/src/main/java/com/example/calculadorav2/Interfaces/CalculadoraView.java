package com.example.calculadorav2.Interfaces;

/**
 * The CalculadoraView for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Interface que sera implementada por Calculadora
 */
public interface CalculadoraView {


    void setCheckNum(String factor);
    void setCheckNumFloat(String factor);
    void checkDoOperation();

    void reset();
    void showResult(String result);
}
