package com.example.calculadorav2.Interactors;

import com.example.calculadorav2.Interfaces.CalculadoraInteractor;
import com.example.calculadorav2.Interfaces.CalculadoraPresenter;
import com.example.calculadorav2.Interfaces.OnCalcuFinishListener;

/**
 * The CalculadoraInteractorImple for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Clase implementa la interface CalculadoraInteractor
 */

public class CalculadoraInteractorImpl implements CalculadoraInteractor {

    private double factor1;
    private double factor2;

    private double result;
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
        this.presenter = presenter;
    }

    /**
     * Metodo que obtiene el valor de Result
     */
    public double getResult() {
        return result;
    }

    /**
     * Metodo que actuliza el valor de Result
     * @param result
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Metodo para calcular la suma
     * @param factor1
     * @param factor2
     */
    @Override
    public void operatePlus(String factor1, String factor2) {
        castFactors(factor1,factor2);

        result=this.factor1+this.factor2;
        presenter.showResult(Double.toString(result));

    }

    /**
     * Metodo para calcular la resta
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateSubstraction(String factor1, String factor2) {
        castFactors(factor1,factor2);

        result=this.factor1-this.factor2;
        presenter.showResult(Double.toString(result));
    }

    /**
     * Metodo para calcular la multiplicacion
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateMultiply(String factor1, String factor2) {
        castFactors(factor1,factor2);

        result=this.factor1*this.factor2;
        presenter.showResult(Double.toString(result));
    }

    /**
     * Metodo para calcular la division
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateDivide(String factor1, String factor2) {
        castFactors(factor1,factor2);
        try{
            if(this.factor2!=0 ){
                result=this.factor1/this.factor2;
            }
        }catch(Exception e){
            System.out.println("No puede realizar una division para cero");
        }
        presenter.showResult(Double.toString(result));
    }

    /**
     * Metodo para castear los parametros en double
     * @param factor1
     * @param factor2
     */
    public void castFactors(String factor1, String factor2){
        this.factor1=Double.parseDouble(factor1.toString());
        this.factor2=Double.parseDouble(factor2.toString());
    }
}
