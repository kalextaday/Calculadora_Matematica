package com.example.calculadorav30.Interfaces;

import com.example.calculadorav30.Interactors.Numero;

public interface CalcuCientiInteractor {

    Numero operateSen(String _factor1);

    Numero operateCos(String _factor1);

    Numero operateLoga(String _factor1);

    Numero operateModule(String _factor1, String _factor2);

}
