package com.example.calculadorav30.Interfaces;

public interface CalcuCientiView {

    void setCheckNum(String factor);

    void setCheckNumFloat(String factor);

    void checkDoOperation();

    void showResult(String _result);

    void showMessageError(String _message);
}
