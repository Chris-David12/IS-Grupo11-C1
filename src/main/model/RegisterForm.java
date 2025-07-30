package main.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import main.controller.controleRegister;
import java.util.regex.Pattern;

public class RegisterForm extends AuthPanel {
    protected JButton registerButton;

    public RegisterForm() {
        super();
        setupForm();
    }

    private void setupForm() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 40, 5, 40);

        // Campos del formulario
        usuarioField = new RoundedTextField(40, 15, 15);
        addFormField(gbc, "NOMBRE Y APELLIDO:", usuarioField);

        cedulaField = new RoundedTextField(40, 15, 15);
        addFormField(gbc, "CÉDULA:", cedulaField);

        emailField = new RoundedTextField(40, 15, 15);
        addFormField(gbc, "CORREO ELECTRÓNICO:", emailField);

        passField = new RoundedPasswordField(40, 15, 15);
        addFormField(gbc, "CONTRASEÑA:", passField);

        confirmPassField = new RoundedPasswordField(40, 15, 15);
        addFormField(gbc, "CONFIRMAR CONTRASEÑA:", confirmPassField);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(39, 39, 39));
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, gbc);

        registerButton = createRoundedButton("Registrarse");
        buttonPanel.add(registerButton);
    }

    public void setRegisterListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }

    public boolean validateFields() {
        String nombreApellido = usuarioField.getText().trim();
        String cedula = cedulaField.getText().trim();
        String email = emailField.getText().trim();
        String contrasenia = new String(passField.getPassword());
        String confirmacion = new String(confirmPassField.getPassword());

        // Validación nombre y apellido
        if (nombreApellido.length() < 12) {
            showError("El nombre y apellido deben tener al menos 12 caracteres.");
            return false;
        }

        if (!Pattern.matches("^[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]+$", nombreApellido)) {
            showError("El nombre no debe contener caracteres especiales ni números.");
            return false;
        }

        // Validación cédula
        if (!Pattern.matches("^\\d+$", cedula)) {
            showError("La cédula solo debe contener números.");
            return false;
        }

        // Validación email
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email)) {
            showError("Por favor ingrese un correo electrónico válido.");
            return false;
        }

        // Validación contraseña
        if (!validatePassword(contrasenia)) {
            showError("<html>La contraseña debe cumplir con:<br>" +
                    "- Mínimo 8 caracteres<br>" +
                    "- Al menos una mayúscula<br>" +
                    "- Al menos un número<br>" +
                    "- Al menos un caracter especial</html>");
            return false;
        }

        // Validación coincidencia
        if (!contrasenia.equals(confirmacion)) {
            showError("Las contraseñas no coinciden.");
            return false;
        }

        return true;
    }

    private boolean validatePassword(String password) {
        return password.length() >= 8 &&
                Pattern.matches(".*[A-Z].*", password) &&
                Pattern.matches(".*\\d.*", password) &&
                Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*", password);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    public boolean registerUser() {
        String nombreApellido = usuarioField.getText().trim();
        String cedula = cedulaField.getText().trim();
        String email = emailField.getText().trim();
        String contrasenia = new String(passField.getPassword());

        controleRegister R = new controleRegister();
        if (!R.Validar(cedula)) {
            if (R.Verificar(cedula, nombreApellido)) {
                R.RegistrarUser(cedula, nombreApellido, email, contrasenia);
                JOptionPane.showMessageDialog(this,
                        "Registro exitoso. Bienvenido " + nombreApellido,
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                showError("El usuario no pertenece a la comunidad universitaria.");
                return false;
            }
        } else {
            showError("El usuario ya existe.");
            return false;
        }
    }
}