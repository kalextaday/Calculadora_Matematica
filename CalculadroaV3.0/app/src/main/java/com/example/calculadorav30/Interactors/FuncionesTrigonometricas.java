package com.example.calculadorav30.Interactors;

public final class FuncionesTrigonometricas {

    static double serieCosTaylor(double _angle) {
        double adding, summation = 0, accuracy = 0.0001d;

        int upLimit = 0;

        do {
            adding = (Math.pow(-1, upLimit) / factorial(2 * upLimit));
            adding = adding * Math.pow(_angle, 2 * upLimit);


            summation = summation + adding;
            upLimit = upLimit + 1;
        } while (Math.abs(adding) > accuracy);

        return summation;
    }

    static double serieSenTaylor(double _angle) {
        double adding, summation = 0, accuracy = 0.0001d;

        int upLimit = 0;

        do {
            adding = Math.pow(-1, upLimit) / factorial((2 * upLimit)+1);
            adding = adding * Math.pow(_angle, (2 * upLimit)+1);


            summation = summation + adding;
            upLimit = upLimit + 1;
        } while (Math.abs(adding) > accuracy);

        return summation;
    }

    static double factorial(int number) {
        double factorial = 1.0;

        while (number != 0) {
            factorial *= number--;
        }

        return factorial;
    }

    static double castGradeToRadians(double _grades){
        return Math.toRadians(_grades);
    }
}
