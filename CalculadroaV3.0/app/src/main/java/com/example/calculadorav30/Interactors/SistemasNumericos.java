package com.example.calculadorav30.Interactors;

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

}
