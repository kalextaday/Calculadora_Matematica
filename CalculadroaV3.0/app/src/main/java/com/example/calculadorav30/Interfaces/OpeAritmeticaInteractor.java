package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

/**
 * The CalculadoraInteractor for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Interface que sera implementada por CalculadoraInteractorImpl
 */
public interface OpeAritmeticaInteractor {

    Numero operatePlus(String _factor1, String _factor2);

    Numero operateSubstraction(String _factor1, String _factor2);

    Numero operateMultiply(String _factor1, String _factor2);

    Numero operateDivide(String _factor1, String _factor2);

    Numero operatePow(String _factor1, String _factor2);

    Numero operateRadical(String _factor1, String _factor2);

    Numero operatePercent(String _factor1, String _factor2);

}