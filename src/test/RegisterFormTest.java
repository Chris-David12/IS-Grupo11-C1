import org.junit.*;

import main.model.RegisterForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static org.junit.jupiter.api.Assertions.*;

class RegisterFormTest {
    private RegisterForm registerForm;
    
    @Before
    void setUp() {
        registerForm = new RegisterForm();
    }
    
    @Test
    void testValidateFields_NombreValido() {
        registerForm.usuarioField.setText("Juan Pérez");
        registerForm.cedulaField.setText("12345678");
        registerForm.emailField.setText("juan@example.com");
        registerForm.passField.setText("Pass123!");
        registerForm.confirmPassField.setText("Pass123!");
        
        assertTrue(registerForm.validateFields());
    }
    
    @Test
    void testValidateFields_NombreInvalido() {
        registerForm.usuarioField.setText("Juan123");
        registerForm.cedulaField.setText("12345678");
        registerForm.emailField.setText("juan@example.com");
        registerForm.passField.setText("Pass123!");
        registerForm.confirmPassField.setText("Pass123!");
        
        assertFalse(registerForm.validateFields());
    }
    
    @Test
    void testValidateFields_CedulaInvalida() {
        registerForm.usuarioField.setText("Juan Pérez");
        registerForm.cedulaField.setText("123abc");
        registerForm.emailField.setText("juan@example.com");
        registerForm.passField.setText("Pass123!");
        registerForm.confirmPassField.setText("Pass123!");
        
        assertFalse(registerForm.validateFields());
    }
    
    @Test
    void testValidateFields_EmailInvalido() {
        registerForm.usuarioField.setText("Juan Pérez");
        registerForm.cedulaField.setText("12345678");
        registerForm.emailField.setText("juan@");
        registerForm.passField.setText("Pass123!");
        registerForm.confirmPassField.setText("Pass123!");
        
        assertFalse(registerForm.validateFields());
    }
    
    @Test
    void testValidateFields_PasswordInvalida() {
        registerForm.usuarioField.setText("Juan Pérez");
        registerForm.cedulaField.setText("12345678");
        registerForm.emailField.setText("juan@example.com");
        registerForm.passField.setText("pass");
        registerForm.confirmPassField.setText("pass");
        
        assertFalse(registerForm.validateFields());
    }
    
    @Test
    void testValidateFields_PasswordsNoCoinciden() {
        registerForm.usuarioField.setText("Juan Pérez");
        registerForm.cedulaField.setText("12345678");
        registerForm.emailField.setText("juan@example.com");
        registerForm.passField.setText("Pass123!");
        registerForm.confirmPassField.setText("Pass123?");
        
        assertFalse(registerForm.validateFields());
    }
    
    @Test
    void testSetRegisterListener() {
        ActionListener listener = (ActionEvent e) -> {};
        registerForm.setRegisterListener(listener);
        
        assertNotNull(registerForm.registerButton.getActionListeners());
        assertEquals(1, registerForm.registerButton.getActionListeners().length);
    }
}
