package com.example.calculadorav30.Interactors;

public final class OperacionesAlgebraicas {

    public static double pow(double _base,double _exponent){
        double result;
        result=Math.pow(_base,_exponent);

        return result;
    }

    public static double radical(double _indice,double _radicando){
        double result;
        int aRdicando=(int) _radicando;
        int tempRdicando=(int) _radicando;
        int tempIndice=(int) _indice;
        int tempRaiz=0;
        int i=2;

        for (i=2;i<aRdicando && tempRaiz<tempIndice;i++){
            while((tempRdicando%i)==0 && tempRdicando>1){
                tempRdicando=tempRdicando/i;
                tempRaiz++;
            }
            if(tempRaiz>tempIndice){
                tempRdicando=aRdicando;
                tempRaiz=0;
            }
        }
        if((tempRaiz==tempIndice) && (tempRdicando<=1)){
            //factor.setValue((i-1));
            result=i-1;
        }else{
            //double denominator=castFactors(_factor1);
            //factor=operatePow(_factor2,Double.toString(1/denominator));
            //factor.setValue(1);
            result=1;
        }

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
