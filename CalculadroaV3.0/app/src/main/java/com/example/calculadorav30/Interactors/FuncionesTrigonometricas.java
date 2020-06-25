package com.example.calculadorav30.Interactors;

/**
 * The FuncionesTrigonometricas for the Application
 * @author Kevin Taday
 * @version 3.0
 * Clase estatica para calcular funciones trigonometricas
 */
public final class FuncionesTrigonometricas {

    public static double serieCosTaylor(double _angle) {
        double adding, summation = 0, accuracy = 0.0001d;
        _angle = Math.toRadians(_angle);

        int upLimit = 0;

        do {
            adding = (Math.pow(-1, upLimit) / factorial(2 * upLimit));
            adding = adding * Math.pow(_angle, 2 * upLimit);


            summation = summation + adding;
            upLimit = upLimit + 1;
        } while (Math.abs(adding) > accuracy);

        return summation;
    }

    public static double serieSenTaylor(double _angle) {
        double adding, summation = 0, accuracy = 0.0001d;
        _angle = Math.toRadians(_angle);

        int upLimit = 0;

        do {
            adding = Math.pow(-1, upLimit) / factorial((2 * upLimit)+1);
            adding = adding * Math.pow(_angle, (2 * upLimit)+1);


            summation = summation + adding;
            upLimit = upLimit + 1;
        } while (Math.abs(adding) > accuracy);

        return summation;
    }

    public static double logarithm(double _arg){
        double loga;

        loga=Math.log10(_arg);

        return loga;
    }

    public static double factorial(int number) {
        double factorial = 1.0;

        while (number != 0) {
            factorial *= number--;
        }

        return factorial;
    }

    public static double castGradeToRadians(double _grades){
        return Math.toRadians(_grades);
    }
}
