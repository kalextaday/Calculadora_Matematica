package com.example.calculadorav30.Views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.example.calculadorav30.Presenters.CalcuGraficPresenter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.example.calculadorav30.R;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

/**
 * The CalculadoraGraficadora Activity for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta es la Vista que mira el usuario
 */
public class CalculadoraGraficadora extends AppCompatActivity {

    /**
     * series para almacenar los puntos de la grafica
     */
    private LineGraphSeries<DataPoint> series;

    /**
     * graph es el canvas donde se presenta el grafico
     */
    private GraphView graph;

    /**
     * factor1,operation donde se almacena la funcion el angulo
     */
    private String factor1,operation;

    /**
     * presenter para enviar la peticion al presentador
     */
    private CalcuGraficPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_grafic);


        graph = (GraphView) findViewById(R.id.graph);

        series = new LineGraphSeries<DataPoint>();

        /*double y,x;
        x = -5.0;
        y = 0.0;*/

        Bundle miBundle=this.getIntent().getExtras();
        if(miBundle!=null){
            operation=miBundle.getString("Operacion");
            factor1=miBundle.getString("Angulo");
        }

        /*
        if(factor1!=null){
            presenter=new CalcuGraficPresenter(operation,factor1);
            series=presenter.doGraphic(series);
        }else{
            presenter=new CalcuGraficPresenter();

            if(operation.equals("seno")){
                series=presenter.findPointSen(x,y,series);
            }else{
                series=presenter.findPointCos(x,y,series);
            }
        }*/
        doGraphic();

        configuration();

        graph.addSeries(series);

    }

    public void prevActivity(View view) {
        finish();
    }

    public void doGraphic(){
        double y,x;
        x = -5.0;
        y = 0.0;
        if(factor1!=null){
            presenter=new CalcuGraficPresenter(operation,factor1);
            series=presenter.doGraphic(series);
        }else{
            presenter=new CalcuGraficPresenter();

            if(operation.equals("seno")){
                series=presenter.findPointSen(x,y,series);
            }else{
                series=presenter.findPointCos(x,y,series);
            }
        }
    }

    public void configuration(){
        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-2);
        graph.getViewport().setMaxY(2);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(4);
        graph.getViewport().setMaxX(10);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        // legend
        series.setTitle(operation);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setTextSize(75.2f);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(CalculadoraGraficadora.this, "PUNTO: "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        // styling series
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(5);
    }
}
