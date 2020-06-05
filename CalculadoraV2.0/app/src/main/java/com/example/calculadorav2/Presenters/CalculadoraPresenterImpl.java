package com.example.calculadorav2.Presenters;

import com.example.calculadorav2.Interactors.CalculadoraInteractorImpl;
import com.example.calculadorav2.Interfaces.CalculadoraInteractor;
import com.example.calculadorav2.Interfaces.CalculadoraPresenter;
import com.example.calculadorav2.Interfaces.CalculadoraView;
import com.example.calculadorav2.Interfaces.OnCalcuFinishListener;

/**
 * The CalculadoraPresenterImple for the Application
 * @author Kevin Taday
 * @version 2.0
 * Esta Clase implementa la interface CalculadoraPresenter
 */

public class CalculadoraPresenterImpl implements CalculadoraPresenter {

    private CalculadoraView view;
    private CalculadoraInteractor interactor;

    /**
     * Metodo constructor de la clase cuando la vista solicita al presentador
     * @param view
     */
    public CalculadoraPresenterImpl(CalculadoraView view) {
        this.view = view;
        interactor=new CalculadoraInteractorImpl(this);
    }

    /**
     * Este metodo llama al metodo operatePlus del Modelo o Interactor
     * @param factor1
     * @param factor2
     */
    @Override
    public void operatePlus(String factor1, String factor2) {
        if (interactor != null) {
            interactor.operatePlus(factor1, factor2);
        }
    }

    /**
     * Este metodo llama al metodo operateSubstraction del Modelo o Interactor
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateSubstraction(String factor1, String factor2) {
        if (interactor != null) {
            interactor.operateSubstraction(factor1, factor2);
        }
    }

    /**
     * Este metodo llama al metodo operateMultiply del Modelo o Interactor
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateMultiply(String factor1, String factor2) {
        if (interactor != null) {
            interactor.operateMultiply(factor1, factor2);
        }
    }

    /**
     * Este metodo llama al metodo operateDivide del Modelo o Interactor
     * @param factor1
     * @param factor2
     */
    @Override
    public void operateDivide(String factor1, String factor2) {
        if (interactor != null) {
            interactor.operateDivide(factor1, factor2);
        }
    }

    /**
     * Este metodo envia la respuesta a la Vista
     */
    @Override
    public void showResult(String result) {
        if (view != null) {
            view.showResult(result);
        }
    }

    @Override
    public void invalidOperation() {

    }
}
