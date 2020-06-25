package com.example.calculadorav30.Presenters;

import com.example.calculadorav30.Interactors.FuncionesTrigonometricas;
import com.example.calculadorav30.Interactors.Numero;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * The CalcuGraficPresenter for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta Clase implementa la interface CalculadoraPresenter
 */
public class CalcuGraficPresenter {

    /**
     * view para obtener la vista
     * interactor para poder solicitar al modelo
     * factor para manejar un objeto de la clase numero
     * factMemory para manejar numero en memoria
     */
    private Numero factor;
    private String operacion;
    private String angulo;


    public CalcuGraficPresenter() {
    }

    /**
     * Metodo constructor que inicializa la operacion y el angulo
     * @param _operacion la funcion seno o coseno
     * @param _angulo el angulo
     */
    public CalcuGraficPresenter(String _operacion,String _angulo) {
        this.operacion=_operacion;
        this.angulo=_angulo;
        factor=new Numero();
    }

    /**
     * Metodo que realiza la grafica
     * @param series objeto de tipo LineGraphSeries<DataPoint>
     * @return LineGraphSeries<DataPoint>
     */
    public LineGraphSeries<DataPoint> doGraphic(LineGraphSeries<DataPoint> series){
        if(operacion.equals("seno")){
            operateSen();
        }else if(operacion.equals("coseno")){
            operateCos();
        }

        series=findPoint();
        return series;
    }

    /**
     * Calcula el valor del seno
     */
    public void operateSen() {
        double value=Double.valueOf(angulo);
        factor.setValue(FuncionesTrigonometricas.serieSenTaylor(value));

    }

    /**
     * Calcula el valor del coseno
     */
    public void operateCos() {
        double value=Double.valueOf(angulo);
        factor.setValue(FuncionesTrigonometricas.serieCosTaylor(value));

    }

    /**
     * Metodo para encontrar puntos del angulo de una funcion
     * @return LineGraphSeries<DataPoint>
     */
    public LineGraphSeries<DataPoint> findPoint(){
        double result=factor.getValue();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-5, result),
                new DataPoint(5, result)
        });

        return series;
    }

    /**
     * Metodo para encontrar puntos para la funcion seno
     * @return LineGraphSeries<DataPoint>
     */
    public LineGraphSeries<DataPoint> findPointSen(double x, double y, LineGraphSeries<DataPoint> series){
        for(int i =0; i<100; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 100);
        }
        return series;
    }

    /**
     * Metodo para encontrar puntos para la funcion coseno
     * @return LineGraphSeries<DataPoint>
     */
    public LineGraphSeries<DataPoint> findPointCos(double x, double y, LineGraphSeries<DataPoint> series){
        for(int i =0; i<100; i++) {
            x = x + 0.1;
            y = Math.cos(x);
            series.appendData(new DataPoint(x, y), true, 100);
        }
        return series;
    }


    /**
     * Metodos Getter and Setter
     */
    public Numero getFactor() {
        return factor;
    }

    public void setFactor(Numero factor) {
        this.factor = factor;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getAngulo() {
        return angulo;
    }

    public void setAngulo(String angulo) {
        this.angulo = angulo;
    }

}
