import javax.swing.*;

import main.controller.controlerLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.util.regex.Pattern;

public class LoginVisual extends JFrame {

    // Mantener las mismas variables de instancia para los campos
    private JTextField usuarioField;
    private JPasswordField passField;
    private JButton entrarButton;

    public LoginVisual() {
        setTitle("Comedor Estudiantil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1024, 768));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo (igual)
        JPanel panelIzquierdo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                ImageIcon fondo = new ImageIcon("../assets/comedor(1).jpeg");
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

        // Panel derecho: solo login
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(39, 39, 39));
        panelDerecho.setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(119, 182, 201));
        panelTitulo.setPreferredSize(new Dimension(0, 90));

        JLabel title = new JLabel("INICIAR SESIÓN");
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

        // NOMBRE Y APELLIDO
        JLabel usuarioLabel = new JLabel("CEDULA");
        usuarioLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        usuarioLabel.setForeground(Color.WHITE);
        gbcForm.gridy++;
        formularioPanel.add(usuarioLabel, gbcForm);

        usuarioField = new JTextField();
        usuarioField.setBackground(new Color(96, 96, 96));
        usuarioField.setForeground(Color.WHITE);
        usuarioField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usuarioField.setPreferredSize(new Dimension(500, 30)); // Tamaño constante

        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.NONE;
        gbcForm.weightx = 0.0;
        formularioPanel.add(usuarioField, gbcForm);

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
        passField.setPreferredSize(new Dimension(500, 30)); // Tamaño constante

        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.NONE;
        gbcForm.weightx = 0.0;
        formularioPanel.add(passField, gbcForm);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(39, 39, 39));
        gbcForm.gridy++;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        formularioPanel.add(buttonPanel, gbcForm);

        // Botón de entrar
        entrarButton = new JButton("Entrar");
        entrarButton.setPreferredSize(new Dimension(200, 45));
        entrarButton.setBackground(new Color(70, 130, 180));
        entrarButton.setForeground(Color.WHITE);
        entrarButton.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPanel.add(entrarButton);

        // Texto "ya tienes cuenta" (mismo texto y estilo)
        JLabel cuentaLabel = new JLabel(
                "<html><span style='color:#CCCCCC;'>¿No tienes una cuenta? </span>" +
                        "<span style='color:#4FC3F7;'><u>Registrate</u></span></html>");
        cuentaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cuentaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(cuentaLabel);

        // Agregar los paneles principales
        // Cambiado el orden: primero panelDerecho (login), luego panelIzquierdo
        // (imagen/logo)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelDerecho, panelIzquierdo);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);

        // ActionListener solo para login
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = usuarioField.getText().trim();
                String contrasenia = new String(passField.getPassword());

                // Validar que no estén vacíos
                if (cedula.isEmpty() || contrasenia.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginVisual.this,
                            "Por favor, complete ambos campos.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el usuario solo contenga números
                if (!Pattern.matches("^\\d+$", cedula)) {
                    JOptionPane.showMessageDialog(LoginVisual.this,
                            "El nombre de usuario debe contener solo números (cédula).",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Aquí iría la lógica real de autenticación
                controlerLogin controlador = new controlerLogin();
                if (controlador.Validar(cedula, contrasenia)) {
                    
                    String rolview = null;
                    rolview = controlador.detectarRol();
                    if (rolview.equals("Comensal")) {
                        InicioVisual inicioV = new InicioVisual();
                        inicioV.setVisible(true);
                        dispose();
                    } else {
                        InicioVisualAdmin inicioVA = new InicioVisualAdmin();
                        inicioVA.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginVisual.this,
                            "Cédula y/o contraseña incorrectos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar validador en tiempo real para solo permitir números
        usuarioField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); // Ignorar el caracter si no es número
                    getToolkit().beep(); // Sonido de alerta
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginVisual();
        });
    }
}