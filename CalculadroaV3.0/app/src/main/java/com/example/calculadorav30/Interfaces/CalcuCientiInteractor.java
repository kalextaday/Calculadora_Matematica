package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

/**
 * The CalcuCientiInteractor for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Interface que sera implementada por CalcuCientiInteractorImpl
 */
public interface CalcuCientiInteractor {

    Numero operateSen(String _factor1);

    Numero operateCos(String _factor1);

    Numero operateLoga(String _factor1);

    Numero operateModule(String _factor1, String _factor2);

}
