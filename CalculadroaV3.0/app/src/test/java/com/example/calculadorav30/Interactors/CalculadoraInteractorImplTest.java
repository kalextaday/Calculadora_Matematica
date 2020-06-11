package com.example.calculadorav30.Interactors;

import com.example.calculadorav30.Interfaces.OpeAritmeticaInteractor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculadoraInteractorImplTest {

    private OpeAritmeticaInteractor interactor;
    private Numero factor;

    @Before
    public void setUp(){
        interactor=new CalculadoraInteractorImpl();
        factor=new Numero();
    }

    @Test
    public void calcuNotNull() {
        assertNotNull(interactor);
    }

    @Test
    public void operatePlusPositiveBoth() {
        factor=interactor.operatePlus("3","4");
        assertEquals("7.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operatePlusPositiveSecond() {
        factor=interactor.operatePlus("-3","4");
        assertEquals("1.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateSubsNegativeSecond() {
        factor=interactor.operateSubstraction("5","-2");
        assertEquals("3.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateSubsNegativeBoth() {
        factor=interactor.operateSubstraction("-9","-2");
        assertEquals("-11.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateMultiplyPositiveBoth() {
        factor=interactor.operateMultiply("4","5");
        assertEquals("20.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateMultiplyNegativeFirst() {
        factor=interactor.operateMultiply("-4","5");
        assertEquals("-20.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateMultiplyNegativeSecond() {
        factor=interactor.operateMultiply("4","-5");
        assertEquals("-20.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateMultiplyNegativeBoth() {
        factor=interactor.operateMultiply("-4","-5");
        assertEquals("20.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateDividePositiveBoth() {
        factor=interactor.operateDivide("50","10");
        assertEquals("5.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateDivideNegativeFirst() {
        factor=interactor.operateDivide("-50","10");
        assertEquals("-5.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateDivideNegativeSecond() {
        factor=interactor.operateDivide("50","-10");
        assertEquals("-5.0",Double.toString(factor.getValue()));
    }

    @Test
    public void operateDivideNegativeBoth() {
        factor=interactor.operateDivide("-50","-10");
        assertEquals("5.0",Double.toString(factor.getValue()));
    }
}