package com.example.calculadorav30.Interactors;

/**
 * The Class Numero for the Application
 * @author Kevin Taday
 * @version 3.0
 * Esta es la clase Numero en el Modelo
 */
public class Numero {

    /**
     * Propiedad value de tipo double
     */
    private double value;

    /**
     * Metodo constructor sin parametros
     */
    public Numero() {
    }

    /**
     * Metodo constructor con parametro de inicializacion
     */
    public Numero(double value) {
        this.value = value;
    }

    /**
     * Metodo get de value
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * Metodo set de value
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }
}
