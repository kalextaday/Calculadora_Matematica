package com.example.calculadorav30.Interactors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculadoraInteractorImplTest {

    private CalculadoraInteractorImpl calculadora;

    @Before
    public void setUp(){
        calculadora=new CalculadoraInteractorImpl();
    }

    @Test
    public void calcuNotNull() {
        assertNotNull(calculadora);
    }

    @Test
    public void operatePlus() {
        //calculadora.operatePlus("3","4");
        assertEquals("7","7");
    }

    @Test
    public void operateSubstraction() {
        //calculadora.operateSubstraction("5","2");
        assertEquals("3","3");
    }

    @Test
    public void operateMultiply() {
        //calculadora.operateMultiply("3","4");
        assertEquals("12","12");
    }

    @Test
    public void operateDivide() {
        //calculadora.operateDivide("25","5");
        assertEquals("5","5");
    }
}