package com.example.miprimeraplicacion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DateValidatorExcludingTest {
    private DateValidatorExcluding validator;

    @Before
    public void setUp() {
        List<Long> disabledDays = Arrays.asList(1700000000000L, 1800000000000L); // Ejemplo de fechas bloqueadas
        validator = new DateValidatorExcluding(disabledDays);
    }

    @Test
    public void testIsValid_ValidDate() {
        assertTrue(validator.isValid(1600000000000L)); // Fecha que no está en la lista
    }
    /*
    @Test
    public void testIsValid_ValidDate() {
        assertFalse(validator.isValid(1600000000000L)); // Este fallo es intencional
    }*/


    @Test
    public void testIsValid_InvalidDate() {
        assertFalse(validator.isValid(1700000000000L)); // Fecha bloqueada
    }

    @Test
    public void testIsValid_EmptyList() {
        DateValidatorExcluding emptyValidator = new DateValidatorExcluding(Arrays.asList());
        assertTrue(emptyValidator.isValid(1700000000000L)); // Sin fechas bloqueadas, todo debería ser válido
    }
}
