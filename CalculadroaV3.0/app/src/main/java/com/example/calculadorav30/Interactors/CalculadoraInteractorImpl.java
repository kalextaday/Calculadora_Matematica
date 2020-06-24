package com.example.calculadorav30.Interactors;

import com.example.calculadorav30.Interfaces.OpeAritmeticaInteractor;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;

/**
 * The CalculadoraInteractorImple for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalculadoraInteractor
 */

public class CalculadoraInteractorImpl implements OpeAritmeticaInteractor {

    private Numero factor;
    private OpeAritmeticaPresenter presenter;

    /**
     * Metodo constructor vacio de la clase
     */
    public CalculadoraInteractorImpl() {
        factor=new Numero();
    }

    /**
     * Metodo constructor de la clase cuando el presentador solicita al Modelo o Interactor
     * @param presenter
     */
    public CalculadoraInteractorImpl(OpeAritmeticaPresenter presenter) {
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

        try{

        }catch (Exception e){

        }
        factor.setValue(factor1.getValue()/factor2.getValue());
        return factor;
    }

    /**
     * Este metodo realiza la potencia de con cualquier base y cualquier exponente
     * @param _factor1
     * @param _factor2
     * @return
     */
    @Override
    public Numero operatePow(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        factor.setValue(Math.pow(factor1.getValue(),factor2.getValue()));
        return factor;
    }

    /**
     * Este metodo realiza la raiz de con cualquier indice y cualquier radicando
     * @param _factor1
     * @param _factor2
     * @return
     */
    @Override
    public Numero operateRadical(String _factor1, String _factor2) {

        Numero indice=new Numero(castFactors(_factor1));
        Numero radicando=new Numero(castFactors(_factor2));

        factor.setValue(OperacionesAlgebraicas.radical(indice.getValue(),radicando.getValue()));
        return factor;
    }

    /**
     * Este metodo calcula el modulo
     * @param _factor1
     * @param _factor2
     * @return
     */
    @Override
    public Numero operateModule(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));

        double modTemp=0;
        boolean checkSignFactor=false;

        if(factor1.getValue()<0 || factor2.getValue()<0){
            if(factor1.getValue()<0 && factor2.getValue()>0)
                factor1.setValue(factor1.getValue()*(-1));
            else if(factor1.getValue()>0 && factor2.getValue()<0){
                factor2.setValue(factor2.getValue()*(-1));
                checkSignFactor=true;
            }
            else {
                factor1.setValue(factor1.getValue()*(-1));
                factor2.setValue(factor2.getValue()*(-1));
            }

            modTemp=factor1.getValue()%factor2.getValue();
            modTemp=modTemp*(-1);
            modTemp=modTemp+factor2.getValue();

            if (checkSignFactor)
                modTemp=modTemp*(-1);
        }
        else
            modTemp=factor1.getValue()%factor2.getValue();

        factor.setValue(modTemp);
        return factor;
    }

    @Override
    public Numero operateFactorial(String _factor1) {
        Numero indice=new Numero(castFactors(_factor1));
        //Numero radicando=new Numero(castFactors(_factor2));

        factor.setValue(FuncionesTrigonometricas.factorial((int) indice.getValue()));
        return factor;
    }

    /**
     * Metodo para castear los parametros en double
     * @param _factor
     */
    public double castFactors(String _factor){
        return Double.parseDouble(_factor.toString());
    }

    /**
     * Metodo Get de presenter
     * @return
     */
    public OpeAritmeticaPresenter getPresenter() {
        return presenter;
    }

    /**
     * Metodo set de Presenter
     * @param presenter
     */
    public void setPresenter(OpeAritmeticaPresenter presenter) {
        this.presenter = presenter;
    }
}
