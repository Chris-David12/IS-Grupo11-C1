import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class ControlerLoginTest {
    private static final String TEST_DB = "test_db.txt";
    private controlerLogin controller;
    
    @Before
    public void setUp() throws IOException {
        // Crear archivo de prueba
        try (PrintWriter writer = new PrintWriter(TEST_DB)) {
            writer.println("1");
            writer.println("12345"); // cédula
            writer.println("user"); // rol
            writer.println("John Doe"); // nombre
            writer.println("john@test.com"); // email
            writer.println("password123"); // contraseña
            writer.println("100.00"); // saldo
        }
        
        controller = new controlerLogin();
    }
    
    @After
    public void tearDown() {
        // Eliminar archivos de prueba
        new File(TEST_DB).delete();
        new File("Instancia.txt").delete();
    }
    
    @Test
    public void testValidarCredencialesCorrectas() {
        assertTrue(controller.Validar("12345", "password123"));
    }
    
    @Test
    public void testValidarCredencialesIncorrectas() {
        assertFalse(controller.Validar("12345", "wrongpass"));
    }
    
    @Test
    public void testValidarUsuarioNoExiste() {
        assertFalse(controller.Validar("99999", "password123"));
    }
    
    @Test
    public void testDetectarRolAdmin() throws IOException {
        // Crear instancia de admin para prueba
        try (PrintWriter writer = new PrintWriter("Instancia.txt")) {
            writer.println("12345");
            writer.println("Admin");
            writer.println("Admin User");
            writer.println("admin@test.com");
            writer.println("adminpass");
        }
        
        assertTrue(controller.detectarRol());
    }
    
    @Test
    public void testDetectarRolUsuarioNormal() throws IOException {
        // Crear instancia de usuario normal para prueba
        try (PrintWriter writer = new PrintWriter("Instancia.txt")) {
            writer.println("12345");
            writer.println("User");
            writer.println("Normal User");
            writer.println("user@test.com");
            writer.println("userpass");
            writer.println("50.00");
        }
        
        assertFalse(controller.detectarRol());
    }
}