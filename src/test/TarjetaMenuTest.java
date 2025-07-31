import org.junit.*;

import main.model.TarjetaMenu;

class TarjetaMenuTest {

    @Test
    void testConstructorAndGetters() {
        TarjetaMenu menu = new TarjetaMenu(1, "Desayuno", "2023-01-01", "08:00-10:00", 
                                          "Pan, café, fruta", 50, 100.0, 50.0);
        
        assertEquals(1, menu.getId());
        assertEquals("Desayuno", menu.getTipo());
        assertEquals("2023-01-01", menu.getFecha());
        assertEquals("08:00-10:00", menu.getHorario());
        assertEquals("Pan, café, fruta", menu.getDescripcion());
        assertEquals(50, menu.getCantidadUsuarios());
        assertEquals(100.0, menu.getConstante());
        assertEquals(50.0, menu.getVariable());
        assertTrue(menu.getCCB() > 0); // Verifica que CCB se calculó
    }

    @Test
    void testSetters() {
        TarjetaMenu menu = new TarjetaMenu(1, "", "", "", "", 0, 0, 0);
        
        menu.setTipo("Almuerzo");
        menu.setFecha("2023-01-02");
        menu.setHorario("12:00-14:00");
        menu.setDescripcion("Sopa, plato principal, postre");
        menu.setCantidadUsuarios(100);
        menu.setConstante(200.0);
        menu.setVariable(100.0);
        menu.setCCB(3.5f);
        
        assertEquals("Almuerzo", menu.getTipo());
        assertEquals("2023-01-02", menu.getFecha());
        assertEquals("12:00-14:00", menu.getHorario());
        assertEquals("Sopa, plato principal, postre", menu.getDescripcion());
        assertEquals(100, menu.getCantidadUsuarios());
        assertEquals(200.0, menu.getConstante());
        assertEquals(100.0, menu.getVariable());
        assertEquals(3.5f, menu.getCCB());
    }

    @Test
    void testCalcularCCB() {
        TarjetaMenu menu = new TarjetaMenu(1, "", "", "", "", 0, 0, 0);
        
        float result = menu.calcular(100.0, 50.0, 50);
        // (100 + 50)/50 = 3.0 * 1.2 (merma) = 3.6
        assertEquals(3.6f, result, 0.01);
        
        result = menu.calcular(200.0, 100.0, 100);
        // (200 + 100)/100 = 3.0 * 1.2 = 3.6
        assertEquals(3.6f, result, 0.01);
    }
}