package com.example.calculadorav30.Interactors;

public final class OperacionesAlgebraicas {

    public static double pow(double _base,double _exponent){
        double result;
        result=Math.pow(_base,_exponent);

        return result;
    }

    public static double radical(double _indice,double _radicando){
        double result;

        double raiz = 1.0;
        int a = (int) _radicando;
        int index;
        for(index = 1; index < 10; index++){
            raiz = (raiz + a/raiz) / 2;
        }

        result=raiz;

        return result;
    }

    public static double module(double _dividendo,double _divisor){
        double result;

        double modTemp=0;
        boolean checkSignFactor=false;

        if(_dividendo<0 || _divisor<0){
            if(_dividendo<0 && _divisor>0)
                _dividendo=_dividendo*(-1);
                //_dividendo.setValue(_dividendo*(-1));
            else if(_dividendo>0 && _divisor<0){
                //_divisor.setValue(_divisor*(-1));
                _divisor=_divisor*(-1);
                checkSignFactor=true;
            }
            else {
                //_dividendo.setValue(_dividendo*(-1));
                //_divisor.setValue(_divisor*(-1));
                _dividendo=_dividendo*(-1);
                _divisor=_divisor*(-1);
            }

            modTemp=_dividendo%_divisor;
            modTemp=modTemp*(-1);
            modTemp=modTemp+_divisor;

            if (checkSignFactor)
                modTemp=modTemp*(-1);
        }
        else
            modTemp=_dividendo%_divisor;

        //factor.setValue(modTemp);
        result=modTemp;

        return result;
    }
}
