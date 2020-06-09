package com.example.calculadorav30.Interactors;

import com.example.calculadorav30.Interfaces.OpeAritmeticaInteractor;
import com.example.calculadorav30.Interfaces.CalculadoraPresenter;

/**
 * The CalculadoraInteractorImple for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalculadoraInteractor
 */

public class CalculadoraInteractorImpl implements OpeAritmeticaInteractor {

    private Numero factor;
    private CalculadoraPresenter presenter;

    /**
     * Metodo constructor vacio de la clase
     */
    public CalculadoraInteractorImpl() {
    }

    /**
     * Metodo constructor de la clase cuando el presentador solicita al Modelo o Interactor
     * @param presenter
     */
    public CalculadoraInteractorImpl(CalculadoraPresenter presenter) {
        factor=new Numero();
        this.presenter = presenter;
    }

    public Numero getFactor() {
        return factor;
    }

    public void setFactor(Numero factor) {
        this.factor = factor;
    }

    /**
     * Metodo para calcular la suma
     * @param _factor1
     * @param _factor2
     */
    @Override
    public Numero operatePlus(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        factor.setValue(factor1.getValue()+factor2.getValue());
        return factor;
    }

    /**
     * Metodo para calcular la resta
     * @param _factor1
     * @param _factor2
     */
    @Override
    public Numero operateSubstraction(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        factor.setValue(factor1.getValue()-factor2.getValue());
        return factor;
    }

    /**
     * Metodo para calcular la multiplicacion
     * @param _factor1
     * @param _factor2
     */
    @Override
    public Numero operateMultiply(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        factor.setValue(factor1.getValue()*factor2.getValue());
        return factor;
    }

    /**
     * Metodo para calcular la division
     * @param _factor1
     * @param _factor2
     */
    @Override
    public Numero operateDivide(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        factor.setValue(factor1.getValue()/factor2.getValue());
        return factor;
    }

    /**
     * Metodo para castear los parametros en double
     * @param _factor
     */
    public double castFactors(String _factor){
        return Double.parseDouble(_factor.toString());
    }
}
