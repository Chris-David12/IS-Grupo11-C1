import static org.junit.Assert.*;
import org.junit.*;

import main.controller.controlerInicioUser;

import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControlerInicioUserTest {
    private static final String TEST_INSTANCE = "test_instancia.txt";
    private static final String TEST_DB = "test_db.txt";
    
    @Before
    public void setUp() throws IOException {
        // Crear archivo de instancia de prueba
        try (PrintWriter writer = new PrintWriter(TEST_INSTANCE)) {
            writer.println("12345"); // cédula
            writer.println("User"); // rol
            writer.println("Test User"); // nombre
            writer.println("test@test.com"); // email
            writer.println("testpass"); // contraseña
            writer.println("100.00"); // saldo
        }
        
        // Crear base de datos de prueba
        try (PrintWriter writer = new PrintWriter(TEST_DB)) {
            writer.println("1");
            writer.println("12345"); // cédula
            writer.println("User"); // rol
            writer.println("Test User"); // nombre
            writer.println("test@test.com"); // email
            writer.println("testpass"); // contraseña
            writer.println("100.00"); // saldo
        }
        
        // Configurar la instancia para usar archivos de prueba
        System.setProperty("INSTANCE_FILE", TEST_INSTANCE);
        System.setProperty("DB_FILE", TEST_DB);
    }
    
    @After
    public void tearDown() {
        new File(TEST_INSTANCE).delete();
        new File(TEST_DB).delete();
        controlerInicioUser.limpiarArchivoSesion();
    }
    
    @Test
    public void testGetInstanceCargaDatosCorrectamente() {
        controlerInicioUser instance = controlerInicioUser.getInstance();
        
        assertEquals("12345", instance.cedula);
        assertEquals("User", instance.rol);
        assertEquals("Test User", instance.usuario);
        assertEquals("test@test.com", instance.correo);
        assertEquals("testpass", instance.password);
        assertEquals(100.00f, instance.saldo, 0.001);
    }
    
    @Test
    public void testActualizarBD() throws IOException {
        controlerInicioUser instance = controlerInicioUser.getInstance();
        instance.saldo = 150.00f; // Modificar saldo
        
        instance.actualizarBD();
        
        // Verificar que se actualizó en la BD
        boolean found = false;
        try (Scanner scanner = new Scanner(new File(TEST_DB))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("12345")) {
                    // Saltar las siguientes 5 líneas (rol, nombre, email, pass)
                    for (int i = 0; i < 5; i++) {
                        if (scanner.hasNextLine()) scanner.nextLine();
                    }
                    // La siguiente línea debería ser el saldo actualizado
                    if (scanner.hasNextLine()) {
                        assertEquals("150.0", scanner.nextLine().trim());
                        found = true;
                    }
                }
            }
        }
        
        assertTrue("No se encontró el usuario en la BD o no se actualizó el saldo", found);
    }
    
    @Test
    public void testLimpiarArchivoSesion() {
        controlerInicioUser instance = controlerInicioUser.getInstance();
        controlerInicioUser.limpiarArchivoSesion();
        
        // Verificar que el archivo está vacío
        File file = new File(TEST_INSTANCE);
        assertEquals(0, file.length());
        
        // La instancia debería ser null después de limpiar
        assertNull(controlerInicioUser.controler);
    }
}
