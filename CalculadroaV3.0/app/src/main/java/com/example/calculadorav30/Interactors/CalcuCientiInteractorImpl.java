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

    public Numero operateModule(String _factor1, String _factor2) {
        Numero factor1=new Numero(castFactors(_factor1));
        Numero factor2=new Numero(castFactors(_factor2));
        Numero tmp1=new Numero(castFactors(_factor1));
        Numero tmp2=new Numero(castFactors(_factor2));

        double modTemp=0;
        boolean checkSignFactor=false;

        if((factor1.getValue()<0 || factor2.getValue()<0) && factor1.getValue()%factor2.getValue()!=0){
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
            if((tmp1.getValue()<0 && tmp2.getValue()<0)){
                modTemp=modTemp;
            }else{
                modTemp=modTemp+factor2.getValue();
            }
            //modTemp=modTemp+factor2.getValue();

            if (checkSignFactor)
                modTemp=modTemp*(-1);
        }
        else{
            if(factor1.getValue()<0)
                factor1.setValue(factor1.getValue()*(-1));
            if(factor2.getValue()<0)
                factor2.setValue(factor2.getValue()*(-1));

            modTemp=factor1.getValue()%factor2.getValue();
        }


        factor.setValue(modTemp);
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
