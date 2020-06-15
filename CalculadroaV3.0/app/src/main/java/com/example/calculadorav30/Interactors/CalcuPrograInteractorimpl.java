package com.example.calculadorav30.Interactors;

import com.example.calculadorav30.Interfaces.CalcuPrograInteractor;
import com.example.calculadorav30.Interfaces.CalcuPrograPresenter;

public class CalcuPrograInteractorimpl implements CalcuPrograInteractor {

    private String factor;
    private CalcuPrograPresenter presenter;

    public CalcuPrograInteractorimpl() {
        factor="";
    }

    public CalcuPrograInteractorimpl(CalcuPrograPresenter presenter) {
        factor="";
        this.presenter = presenter;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public CalcuPrograPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(CalcuPrograPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public String operateCastDeToBi(String _factor1) {

        //factor=SistemasNumericos.castDeToBi();
        return factor;
    }

    @Override
    public String operateCastDeToOc(String _factor1) {
        //factor=SistemasNumericos.castDeToOc();

        return factor;
    }

    @Override
    public String operateCastDeToHe(String _factor1) {
        //factor=SistemasNumericos.castDeToHe();

        return factor;
    }

    @Override
    public String operateCastBiToDe(String _factor1) {

        //factor=SistemasNumericos.castBiToDe();
        return factor;
    }

    @Override
    public String operateCastBiToOc(String _factor1) {

        //factor=SistemasNumericos.castBiToOc();
        return factor;
    }

    @Override
    public String operateCastBiToHe(String _factor1) {

        //factor=SistemasNumericos.castBiToHe();
        return factor;
    }

    @Override
    public String operateCastOcToDe(String _factor1) {

        //factor=SistemasNumericos.castOcToDe();
        return factor;
    }

    @Override
    public String operateCastOcToBi(String _factor1) {

        //factor=SistemasNumericos.castOcToBi();
        return factor;
    }

    @Override
    public String operateCastOcToHe(String _factor1) {

        //factor=SistemasNumericos.castOcToHe();
        return factor;
    }

    @Override
    public String operateCastHeToDe(String _factor1) {

        //factor=SistemasNumericos.castHeToDe();
        return factor;
    }

    @Override
    public String operateCastHeToOc(String _factor1) {

        //factor=SistemasNumericos.castHeToOc();
        return factor;
    }

    @Override
    public String operateCastHeToBi(String _factor1) {

        //factor=SistemasNumericos.castHeToBi();
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
