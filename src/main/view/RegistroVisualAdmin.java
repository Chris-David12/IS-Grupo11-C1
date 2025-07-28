import javax.swing.*;

import main.controller.controleRegister;
import main.model.RoundedPasswordField;
import main.model.RoundedTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistroVisualAdmin extends JFrame {

    // Mantener las mismas variables de instancia para los campos
    private JTextField usuarioField;
    private JTextField cedulaField;
    private JTextField emailField;
    private JPasswordField passField;
    private JPasswordField confirmPassField;
    private JButton entrarButton;

    public RegistroVisualAdmin() {
        setTitle("Comedor Estudiantil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1024, 768));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo
        JPanel panelIzquierdo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                ImageIcon fondo = new ImageIcon("../assets/comedor(2).jpeg");
                g2d.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.setColor(new Color(16, 198, 90, 120));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelIzquierdo.setLayout(new GridBagLayout());

        ImageIcon iconoOriginal = new ImageIcon("../assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);

        JLabel logo = new JLabel(iconoFinal);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        panelIzquierdo.add(logo, gbc);

        JLabel nombreSistema = new JLabel("COMEDOR ESTUDIANTIL");
        nombreSistema.setFont(new Font("Roboto Black", Font.BOLD, 34));
        nombreSistema.setForeground(Color.WHITE);
        gbc.gridy = 1;
        panelIzquierdo.add(nombreSistema, gbc);

        // Panel derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(39, 39, 39));
        panelDerecho.setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(119, 182, 201));
        panelTitulo.setPreferredSize(new Dimension(0, 90));

        JLabel title = new JLabel("CREAR CUENTA");
        title.setFont(new Font("Roboto Black", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        panelTitulo.add(title);
        panelDerecho.add(panelTitulo, BorderLayout.NORTH);

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

        // Campos del formulario con bordes redondeados
        Dimension campoDimension = new Dimension(500, 30);
        int borderRadius = 15;

        // NOMBRE Y APELLIDO
        JLabel usuarioLabel = new JLabel("NOMBRE Y APELLIDO:");
        usuarioLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        usuarioLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(usuarioLabel, gbcForm);

        usuarioField = new RoundedTextField(40, borderRadius, borderRadius);
        usuarioField.setBackground(new Color(96, 96, 96));
        usuarioField.setForeground(Color.WHITE);
        usuarioField.setBorder(BorderFactory.createCompoundBorder(
                usuarioField.getBorder(),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        usuarioField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(usuarioField, gbcForm);

        // CÉDULA
        JLabel cedulaLabel = new JLabel("CÉDULA:");
        cedulaLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        cedulaLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(cedulaLabel, gbcForm);

        cedulaField = new RoundedTextField(40, borderRadius, borderRadius);
        cedulaField.setBackground(new Color(96, 96, 96));
        cedulaField.setForeground(Color.WHITE);
        cedulaField.setBorder(BorderFactory.createCompoundBorder(
                cedulaField.getBorder(),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        cedulaField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(cedulaField, gbcForm);

        // CORREO ELECTRÓNICO
        JLabel emailLabel = new JLabel("CORREO ELECTRÓNICO:");
        emailLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        emailLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(emailLabel, gbcForm);

        emailField = new RoundedTextField(40, borderRadius, borderRadius);
        emailField.setBackground(new Color(96, 96, 96));
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(BorderFactory.createCompoundBorder(
                emailField.getBorder(),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        emailField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(emailField, gbcForm);

        // CONTRASEÑA
        JLabel passLabel = new JLabel("CONTRASEÑA:");
        passLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        passLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(passLabel, gbcForm);

        passField = new RoundedPasswordField(40, borderRadius, borderRadius);
        passField.setBackground(new Color(96, 96, 96));
        passField.setForeground(Color.WHITE);
        passField.setBorder(BorderFactory.createCompoundBorder(
                passField.getBorder(),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        passField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(passField, gbcForm);

        // CONFIRMAR CONTRASEÑA
        JLabel confirmPassLabel = new JLabel("CONFIRMAR CONTRASEÑA:");
        confirmPassLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        confirmPassLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(confirmPassLabel, gbcForm);

        confirmPassField = new RoundedPasswordField(40, borderRadius, borderRadius);
        confirmPassField.setBackground(new Color(96, 96, 96));
        confirmPassField.setForeground(Color.WHITE);
        confirmPassField.setBorder(BorderFactory.createCompoundBorder(
                confirmPassField.getBorder(),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        confirmPassField.setPreferredSize(campoDimension);
        gbcForm.gridy++;
        formularioPanel.add(confirmPassField, gbcForm);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(39, 39, 39));
        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        formularioPanel.add(buttonPanel, gbcForm);

        // Botón de registro con bordes redondeados
        entrarButton = new JButton("Registrarse") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.dispose();
            }
        };
        entrarButton.setContentAreaFilled(false);
        entrarButton.setOpaque(false);
        entrarButton.setPreferredSize(new Dimension(200, 45));
        entrarButton.setBackground(new Color(70, 130, 180));
        entrarButton.setForeground(Color.WHITE);
        entrarButton.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(entrarButton);

        // Agregar los paneles principales
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);

        // ActionListener (sin cambios)
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreApellido = usuarioField.getText().trim();
                String cedula = cedulaField.getText().trim();
                String email = emailField.getText().trim();
                String contrasenia = new String(passField.getPassword());
                String confirmacion = new String(confirmPassField.getPassword());

                // Validación nombre y apellido
                if (nombreApellido.length() < 12) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "El nombre y apellido deben tener al menos 12 caracteres.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Pattern.matches("^[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]+$", nombreApellido)) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "El nombre no debe contener caracteres especiales ni números.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación cédula
                if (!Pattern.matches("^\\d+$", cedula)) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "La cédula solo debe contener números.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación email
                if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email)) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "Por favor ingrese un correo electrónico válido.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación combinada de contraseña
                if (!(contrasenia.length() >= 8 &&
                        Pattern.matches(".*[A-Z].*", contrasenia) &&
                        Pattern.matches(".*\\d.*", contrasenia) &&
                        Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*", contrasenia))) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "<html>La contraseña debe cumplir con:<br>" +
                                    "- Mínimo 8 caracteres<br>" +
                                    "- Al menos una mayúscula<br>" +
                                    "- Al menos un número<br>" +
                                    "- Al menos un caracter especial</html>",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación coincidencia de contraseñas
                if (!contrasenia.equals(confirmacion)) {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "Las contraseñas no coinciden.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                controleRegister R = new controleRegister();
                if (!R.Validar(cedula)) {
                    R.RegistrarAdmin(cedula, nombreApellido, email, contrasenia);
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "Registro exitoso. Bienvenido " + nombreApellido,
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RegistroVisualAdmin.this,
                            "El usuario ya existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroVisualAdmin();
        });
    }
}