package com.example.calculadorav2.Interfaces;

/**
 * The CalculadoraInteractor for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Interface que sera implementada por CalculadoraInteractorImpl
 */
public interface CalculadoraInteractor {

    void operatePlus(String factor1,String factor2);

    void operateSubstraction(String factor1,String factor2);

    void operateMultiply(String factor1,String factor2);

    void operateDivide(String factor1,String factor2);

}
