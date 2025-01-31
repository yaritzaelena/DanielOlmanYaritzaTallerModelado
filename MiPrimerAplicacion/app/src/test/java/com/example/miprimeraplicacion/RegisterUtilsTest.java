package com.example.miprimeraplicacion;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public clas RegisterUtilsTest {

    // Pruebas para isVisaOrMastercard
    @Test
    public void Test1IsVisaOrMastercard() {
        assertTrue(RegisterUtils.isVisaOrMastercard("4123456789012345")); // Visa válida
    }

    @Test
    public void Test2IsVisaOrMastercard() {
        assertTrue(RegisterUtils.isVisaOrMastercard("5212345678901234")); // Mastercard válida
    }

    @Test
    public void Test3IsVisaOrMastercard() {
        assertFalse(RegisterUtils.isVisaOrMastercard("3123456789012345")); // Número inválido
    }

    // Pruebas para validatePassword
    @Test
    public void Test1ValidatePassword() {
        assertTrue(RegisterUtils.validatePassword("Abc12345")); // Letras y números
    }

    @Test
    public void Test2ValidatePassword() {
        assertTrue(RegisterUtils.validatePassword("Abc@1234")); // Letras, números y símbolo
    }

    @Test
    public void Test3ValidatePassword() {
        assertFalse(RegisterUtils.validatePassword("12345678")); // Solo letras, menos de 8 caracteres
    }
}
