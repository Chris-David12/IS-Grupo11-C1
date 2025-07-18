import javax.swing.*;

import main.controller.controleRegister;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistroVisualUser extends JFrame {

    // Mantener las mismas variables de instancia para los campos
    private JTextField usuarioField;
    private JTextField cedulaField;
    private JTextField emailField;
    private JPasswordField passField;
    private JPasswordField confirmPassField;
    private JButton entrarButton;

    public RegistroVisualUser() {
        setTitle("Comedor Estudiantil");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar por defecto
        setMinimumSize(new Dimension(1024, 768)); // Tamaño mínimo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 👉 Panel izquierdo: fondo + logo + título (igual funcionalidad)
        JPanel panelIzquierdo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // 🔧 Dibujar imagen de fondo (misma funcionalidad)
                ImageIcon fondo = new ImageIcon("assets/comedor(2).jpeg");
                g2d.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

                // 🌫️ Capa semi-transparente (mismo color)
                g2d.setColor(new Color(16, 198, 90, 120));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelIzquierdo.setLayout(new GridBagLayout());

        // Logo (misma imagen)
        ImageIcon iconoOriginal = new ImageIcon("assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);

        JLabel logo = new JLabel(iconoFinal);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        panelIzquierdo.add(logo, gbc);

        // Nombre del sistema (mismo texto)
        JLabel nombreSistema = new JLabel("COMEDOR ESTUDIANTIL");
        nombreSistema.setFont(new Font("Roboto Black", Font.BOLD, 34));
        nombreSistema.setForeground(Color.WHITE);
        gbc.gridy = 1;
        panelIzquierdo.add(nombreSistema, gbc);

        // 👉 Panel derecho: formulario (misma estructura)
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(39, 39, 39));
        panelDerecho.setLayout(new BorderLayout());

        // Panel de título (mismo color y texto)
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(119, 182, 201));
        panelTitulo.setPreferredSize(new Dimension(0, 90));

        JLabel title = new JLabel("CREAR CUENTA");
        title.setFont(new Font("Roboto Black", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        panelTitulo.add(title);
        panelDerecho.add(panelTitulo, BorderLayout.NORTH);

        // Panel de formulario (mismos campos)
        JPanel formularioPanel = new JPanel();
        formularioPanel.setBackground(new Color(39, 39, 39));
        formularioPanel.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(formularioPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panelDerecho.add(scrollPane, BorderLayout.CENTER);

        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.gridx = 0;
        gbcForm.gridy = 0;
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.insets = new Insets(10, 40, 5, 40);

        // Campos del formulario (los mismos que antes)
        Dimension campoDimension = new Dimension(500, 30); // Tamaño fijo para todos

        // NOMBRE Y APELLIDO
        JLabel usuarioLabel = new JLabel("NOMBRE Y APELLIDO:");
        usuarioLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        usuarioLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(usuarioLabel, gbcForm);

        usuarioField = new JTextField();
        usuarioField.setBackground(new Color(96, 96, 96));
        usuarioField.setForeground(Color.WHITE);
        usuarioField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usuarioField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.NONE;
        gbcForm.weightx = 0.0;
        formularioPanel.add(usuarioField, gbcForm);

        // CÉDULA
        JLabel cedulaLabel = new JLabel("CÉDULA:");
        cedulaLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        cedulaLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(cedulaLabel, gbcForm);

        cedulaField = new JTextField();
        cedulaField.setBackground(new Color(96, 96, 96));
        cedulaField.setForeground(Color.WHITE);
        cedulaField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cedulaField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(cedulaField, gbcForm);

        // CORREO ELECTRÓNICO
        JLabel emailLabel = new JLabel("CORREO ELECTRÓNICO:");
        emailLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        emailLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(emailLabel, gbcForm);

        emailField = new JTextField();
        emailField.setBackground(new Color(96, 96, 96));
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        emailField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(emailField, gbcForm);

        // CONTRASEÑA
        JLabel passLabel = new JLabel("CONTRASEÑA:");
        passLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        passLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(passLabel, gbcForm);

        passField = new JPasswordField();
        passField.setBackground(new Color(96, 96, 96));
        passField.setForeground(Color.WHITE);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(passField, gbcForm);

        // CONFIRMAR CONTRASEÑA
        JLabel confirmPassLabel = new JLabel("CONFIRMAR CONTRASEÑA:");
        confirmPassLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        confirmPassLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(confirmPassLabel, gbcForm);

        confirmPassField = new JPasswordField();
        confirmPassField.setBackground(new Color(96, 96, 96));
        confirmPassField.setForeground(Color.WHITE);
        confirmPassField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        confirmPassField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(confirmPassField, gbcForm);

        // Panel de botones (sin cambios)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(39, 39, 39));
        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        formularioPanel.add(buttonPanel, gbcForm);

        // Botón de registro (mismo texto y colores)
        entrarButton = new JButton("Registrarse");
        entrarButton.setPreferredSize(new Dimension(200, 45));
        entrarButton.setBackground(new Color(70, 130, 180));
        entrarButton.setForeground(Color.WHITE);
        entrarButton.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(entrarButton);

        // Texto "ya tienes cuenta" (mismo texto y estilo)
        JLabel cuentaLabel = new JLabel(
                "<html><span style='color:#CCCCCC;'>¿Ya tienes una cuenta? Haz click </span>" +
                        "<span style='color:#4FC3F7;'><u>aquí</u></span></html>");
        cuentaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cuentaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(cuentaLabel);

        // Agregar los paneles principales
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);

        // Mismo ActionListener sin cambios
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String nombreApellido = usuarioField.getText().trim();
                String cedula = cedulaField.getText().trim();
                String email = emailField.getText().trim();
                String contrasenia = new String(passField.getPassword());
                String confirmacion = new String(confirmPassField.getPassword());

                // Validar nombre y apellido (mínimo 24 caracteres, solo letras y espacios)
                if (nombreApellido.length() < 12) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "El nombre y apellido deben tener al menos 12 caracteres.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches("^[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]+$", nombreApellido)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "El nombre no debe contener caracteres especiales ni números.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar cédula (solo números)
                if (!Pattern.matches("^\\d+$", cedula)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "La cédula solo debe contener números.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar email
                if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "Por favor ingrese un correo electrónico válido.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar contraseña
                if (contrasenia.length() < 8) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "La contraseña debe tener al menos 8 caracteres.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches(".*[A-Z].*", contrasenia)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "La contraseña debe contener al menos una mayúscula.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches(".*\\d.*", contrasenia)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "La contraseña debe contener al menos un número.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*", contrasenia)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "La contraseña debe contener al menos un caracter especial.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar coincidencia de contraseñas
                if (!contrasenia.equals(confirmacion)) {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "Las contraseñas no coinciden.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Si todas las validaciones pasan, proceder con el registro
                controleRegister R = new controleRegister();
                if (!R.Validar(cedula)) {
                    R.RegistrarUser(cedula, nombreApellido, email, contrasenia);
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "Registro exitoso. Bienvenido " + nombreApellido,
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                            LoginVisual loginV = new LoginVisual();
                            loginV.setVisible(true);
                            dispose();
                } else {
                    JOptionPane.showMessageDialog(RegistroVisualUser.this,
                            "El usuario ya existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroVisualUser();
        });
    }
}
