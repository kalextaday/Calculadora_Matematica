package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

/**
 * The CalcuPrograInteractor for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Interface que sera implementada por CalcuPrograPresenterImpl
 */
public interface CalcuPrograInteractor {

    String operateCastDeToBi(String _factor1);

    String operateCastDeToOc(String _factor1);

    String operateCastDeToHe(String _factor1);

    String operateCastBiToDe(String _factor1);

    String operateCastBiToOc(String _factor1);

    String operateCastBiToHe(String _factor1);

    String operateCastOcToDe(String _factor1);

    String operateCastOcToBi(String _factor1);

    String operateCastOcToHe(String _factor1);

    String operateCastHeToDe(String _factor1);

    String operateCastHeToOc(String _factor1);

    String operateCastHeToBi(String _factor1);
}
