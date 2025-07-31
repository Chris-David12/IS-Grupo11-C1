import org.junit.*;

import main.controller.controleRegister;

import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControleRegisterTest {
    private static final String TEST_DB = "test_db.txt";
    private static final String TEST_UNIVERSAL_DB = "test_universal_db.txt";
    private controleRegister controller;
    
    @Before
    public void setUp() throws IOException {
        // Crear base de datos de prueba
        try (PrintWriter writer = new PrintWriter(TEST_DB)) {
            writer.println("1");
            writer.println("11111"); // cédula existente
            writer.println("Estudiante"); // rol
            writer.println("Existing User"); // nombre
            writer.println("existing@test.com"); // email
            writer.println("existingpass"); // contraseña
            writer.println("50.00"); // saldo
        }
        
        // Crear base de datos universal de prueba
        try (PrintWriter writer = new PrintWriter(TEST_UNIVERSAL_DB)) {
            writer.println("12345"); // cédula
            writer.println("New User"); // nombre
            writer.println("Estudiante"); // rol
        }
        
        controller = new controleRegister();
        controleRegister.TEST_DB = TEST_DB;
        controleRegister.TEST_UNIVERSAL_DB = TEST_UNIVERSAL_DB;
    }
    
    @After
    public void tearDown() {
        new File(TEST_DB).delete();
        new File(TEST_UNIVERSAL_DB).delete();
    }
    
    @Test
    public void testValidarDatoExistente() {
        assertTrue(controller.Validar("11111")); // Cédula existente// Email existente
    }
    
    @Test
    public void testValidarDatoNoExistente() {
        assertFalse(controller.Validar("99999")); // Cédula no existente// Email no existente
    }
    
    @Test
    public void testVerificarUsuarioValido() {
        assertTrue(controller.Verificar("12345", "New User"));
        assertEquals("Estudiante", controller.rol);
    }
    
    @Test
    public void testVerificarUsuarioNoValido() {
        assertFalse(controller.Verificar("99999", "Non Existing"));
        assertNull(controller.rol);
    }
    
    @Test
    public void testRegistrarUser() throws IOException {
        controller.rol = "User";
        controller.RegistrarUser("54321", "Test User", "test@test.com", "testpass");
        
        // Verificar que se agregó al archivo
        boolean found = false;
        try (Scanner scanner = new Scanner(new File(TEST_DB))) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals("54321")) {
                    found = true;
                    break;
                }
            }
        }
        
        assertTrue("Usuario no registrado en la BD", found);
    }
    
    @Test
    public void testRegistrarAdmin() throws IOException {
        controller.RegistrarAdmin("98765", "Admin User", "admin@test.com", "adminpass");
        
        // Verificar que se agregó al archivo
        boolean found = false;
        try (Scanner scanner = new Scanner(new File(TEST_DB))) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equals("98765")) {
                    found = true;
                    break;
                }
            }
        }
        
        assertTrue("Admin no registrado en la BD", found);
    }
}