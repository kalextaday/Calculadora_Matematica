package com.example.calculadorav30.Interactors;

import com.example.calculadorav30.Interfaces.CalcuCientiInteractor;
import com.example.calculadorav30.Interfaces.CalcuCientiPresenter;
import com.example.calculadorav30.Interfaces.OpeAritmeticaPresenter;

public class CalcuCientiInteractorImpl implements CalcuCientiInteractor {

    private Numero factor;
    private CalcuCientiPresenter presenter;

    public CalcuCientiInteractorImpl() {
        factor=new Numero();
    }

    public CalcuCientiInteractorImpl(CalcuCientiPresenter presenter) {
        factor=new Numero();
        this.presenter = presenter;
    }

    public Numero getFactor() {
        return factor;
    }

    public void setFactor(Numero factor) {
        this.factor = factor;
    }

    public CalcuCientiPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(CalcuCientiPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Numero operateSen(String _factor1) {
        Numero factor1=new Numero(castFactors(_factor1));

        double result=FuncionesTrigonometricas.serieSenTaylor(factor1.getValue());

        factor.setValue(result);

        return factor;
    }

    @Override
    public Numero operateCos(String _factor1) {
        Numero factor1=new Numero(castFactors(_factor1));

        double result=FuncionesTrigonometricas.serieCosTaylor(factor1.getValue());

        factor.setValue(result);

        return factor;
    }

    @Override
    public Numero operateLoga(String _factor1) {
        Numero factor1=new Numero(castFactors(_factor1));

        double result=FuncionesTrigonometricas.logarithm(factor1.getValue());

        factor.setValue(result);

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
