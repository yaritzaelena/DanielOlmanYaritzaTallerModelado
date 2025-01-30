package com.example.miprimeraplicacion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ReserveHouseActivityTest {
    private ReserveHouseActivity reserveHouse;
    private List<Long> disabledDays;
    private SimpleDateFormat sdf;

    @Before
    public void setUp() {
        reserveHouse = new ReserveHouseActivity();
        disabledDays = new ArrayList<>();
        sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        try {
            // Simulamos que estas fechas están bloqueadas
            disabledDays.add(sdf.parse("10/02/2025").getTime());
            disabledDays.add(sdf.parse("11/02/2025").getTime());
            disabledDays.add(sdf.parse("12/02/2025").getTime());
        } catch (Exception e) {
            fail("Error en la configuración de fechas bloqueadas");
        }

        // 🚀 Inyectamos manualmente las fechas bloqueadas en ReserveHouseActivity
        reserveHouse.disabledDays = disabledDays;

        System.out.println("Fechas bloqueadas cargadas: " + disabledDays);

    }


    @Test
    public void testIsDateBlocked_DateBlocked() {
        assertTrue(reserveHouse.isDateBlocked("10/02/2025", "12/02/2025"));
    }

    @Test
    public void testIsDateBlocked_DateAvailable() {
        assertFalse(reserveHouse.isDateBlocked("13/02/2025", "15/02/2025"));
    }

    @Test
    public void testIsDateBlocked_BorderCase() {
        assertTrue(reserveHouse.isDateBlocked("12/02/2025", "13/02/2025"));
    }
}
