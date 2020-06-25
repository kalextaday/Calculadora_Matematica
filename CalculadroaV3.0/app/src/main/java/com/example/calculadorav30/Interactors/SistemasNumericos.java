package com.example.calculadorav30.Interactors;

/**
 * The CalculadoraInteractorImple for the Application
 * @author Kevin Taday
 * @version 3.0
 * Clase estatica para las conversiones de los sistemas numericos
 */

public final class SistemasNumericos {

    public static String castDeToBi(int decimal){
        String binario = Integer.toBinaryString(decimal);

        return binario;
    }

    public static String castDeToOc(int decimal){
        String octal = Integer.toOctalString(decimal);

        return octal;
    }

    public static String castDeToHe(int decimal){
        String hexadecimal = Integer.toHexString(decimal);

        return hexadecimal;
    }

    public static String castBiToDe(String binario){
        String decimalConvertido="";
        int decimal = Integer.parseInt(binario, 2);

        decimalConvertido=decimalConvertido+decimal;
        return decimalConvertido;
    }

    public static String castBiToOc(String binario){
        int decimal = Integer.parseInt(binario, 2);
        String octal = Integer.toOctalString(decimal);

        return octal;
    }

    public static String castBiToHe(String binario){
        int decimal = Integer.parseInt(binario, 2);
        String hexadecimal = Integer.toHexString(decimal);

        return hexadecimal;
    }

    public static String castOcToHe(String octal){
        int decimal = Integer.parseInt(octal, 8);
        String hexadecimal = Integer.toHexString(decimal);

        return hexadecimal;
    }

    public static String castOcToDe(String octal){
        String decimalConvertido="";
        int decimal = Integer.parseInt(octal, 8);

        decimalConvertido=decimalConvertido+decimal;
        return decimalConvertido;
    }

    public static String castOcToBi(String octal){
        int decimal = Integer.parseInt(octal, 8);

        String binario = Integer.toBinaryString(decimal);

        return binario;
    }

    public static String castHeToDe(String hexadecimal){
        String decimalConvertido="";
        int decimal = Integer.parseInt(hexadecimal, 16);

        decimalConvertido=decimalConvertido+decimal;
        return decimalConvertido;
    }

    public static String castHeToBi(String hexadecimal){
        int decimal = Integer.parseInt(hexadecimal, 16);
        String binario = Integer.toBinaryString(decimal);

        return binario;
    }

    public static String castHeToOc(String hexadecimal){
        int decimal = Integer.parseInt(hexadecimal, 16);
        String octal = Integer.toOctalString(decimal);

        return octal;
    }

    public static void toBinarString(int n){
        int numero, exp, digito;
        double binario;
        numero =n;

        exp=0;
        binario=0;
        while(numero!=0){
            digito = numero % 2;
            binario = binario + digito * Math.pow(10, exp);
            exp++;
            numero = numero/2;
        }
    }

    public static void toDecimaString(String n){
        long decimal = 0;
        int posicion = 0;
        for (int x = n.length() - 1; x >= 0; x--) {
            short digito = 1;
            if (n.charAt(x) == '0') {
                digito = 0;
            }
            double multiplicador = Math.pow(2, posicion);
            decimal += digito * multiplicador;
            posicion++;
        }
    }

}
