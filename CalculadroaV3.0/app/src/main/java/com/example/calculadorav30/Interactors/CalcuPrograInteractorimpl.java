package com.example.calculadorav30.Interactors;

import androidx.annotation.IntegerRes;

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

        factor=SistemasNumericos.castDeToBi(Integer.parseInt(_factor1));
        return factor;
    }

    @Override
    public String operateCastDeToOc(String _factor1) {
        //factor=SistemasNumericos.castDeToOc();
        factor=SistemasNumericos.castDeToOc(Integer.parseInt(_factor1));
        return factor;
    }

    @Override
    public String operateCastDeToHe(String _factor1) {
        //factor=SistemasNumericos.castDeToHe();
        factor=SistemasNumericos.castDeToHe(Integer.parseInt(_factor1));
        return factor;
    }

    @Override
    public String operateCastBiToDe(String _factor1) {

        //factor=SistemasNumericos.castBiToDe();
        factor=SistemasNumericos.castBiToDe(_factor1);
        return factor;
    }

    @Override
    public String operateCastBiToOc(String _factor1) {

        //factor=SistemasNumericos.castBiToOc();
        factor=SistemasNumericos.castBiToOc(_factor1);
        return factor;
    }

    @Override
    public String operateCastBiToHe(String _factor1) {

        //factor=SistemasNumericos.castBiToHe();
        factor=SistemasNumericos.castBiToHe(_factor1);
        return factor;
    }

    @Override
    public String operateCastOcToDe(String _factor1) {

        //factor=SistemasNumericos.castOcToDe();
        factor=SistemasNumericos.castOcToHe(_factor1);
        return factor;
    }

    @Override
    public String operateCastOcToBi(String _factor1) {

        //factor=SistemasNumericos.castOcToBi();
        factor=SistemasNumericos.castOcToBi(_factor1);
        return factor;
    }

    @Override
    public String operateCastOcToHe(String _factor1) {

        //factor=SistemasNumericos.castOcToHe();
        factor=SistemasNumericos.castOcToHe(_factor1);
        return factor;
    }

    @Override
    public String operateCastHeToDe(String _factor1) {

        //factor=SistemasNumericos.castHeToDe();
        factor=SistemasNumericos.castHeToDe(_factor1);
        return factor;
    }

    @Override
    public String operateCastHeToOc(String _factor1) {

        //factor=SistemasNumericos.castHeToOc();
        factor=SistemasNumericos.castHeToOc(_factor1);
        return factor;
    }

    @Override
    public String operateCastHeToBi(String _factor1) {

        //factor=SistemasNumericos.castHeToBi();
        factor=SistemasNumericos.castHeToBi(_factor1);
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
