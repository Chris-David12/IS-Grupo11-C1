
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import main.controller.controlerLogin;
import main.model.AuthPanel;
import main.model.RoundedButton;
import main.model.RoundedTextField;
import main.model.RoundedPasswordField;

public class LoginVisual extends JFrame {
    private AuthPanel authPanel;

    public LoginVisual() {
        setTitle("Comedor Estudiantil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo con imagen
        add(createLeftPanel(), BorderLayout.WEST);

        // Panel derecho con formulario
        add(createRightPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                ImageIcon fondo = new ImageIcon("assets/comedor(1).jpeg");
                g2d.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.setColor(new Color(16, 198, 90, 120));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Logo y título
        ImageIcon logo = new ImageIcon(new ImageIcon("assets/logo.png")
                .getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        panel.add(new JLabel(logo), gbc);

        JLabel title = new JLabel("COMEDOR ESTUDIANTIL");
        title.setFont(new Font("Roboto Black", Font.BOLD, 34));
        title.setForeground(Color.WHITE);
        gbc.gridy = 1;
        panel.add(title, gbc);

        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(39, 39, 39));

        // Título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(119, 182, 201));
        titlePanel.setPreferredSize(new Dimension(0, 90));

        JLabel title = new JLabel("INICIAR SESIÓN");
        title.setFont(new Font("Roboto Black", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        titlePanel.add(title);
        panel.add(titlePanel, BorderLayout.NORTH);

        // Formulario
        authPanel = new AuthPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 40, 5, 40);

        // Campos
        authPanel.usuarioField = new RoundedTextField(40, 15, 15);
        authPanel.addFormField(gbc, "CEDULA", authPanel.usuarioField);

        authPanel.passField = new RoundedPasswordField(40, 15, 15);
        authPanel.addFormField(gbc, "CONTRASEÑA:", authPanel.passField);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(39, 39, 39));
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        authPanel.add(buttonPanel, gbc);

        RoundedButton loginButton = (RoundedButton) authPanel.createRoundedButton("Entrar");
        buttonPanel.add(loginButton);

        // Enlace a registro
        JLabel registerLink = createRegisterLink();
        buttonPanel.add(registerLink);

        JScrollPane scrollPane = new JScrollPane(authPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Listeners
        setupListeners(loginButton);

        return panel;
    }

    private JLabel createRegisterLink() {
        JLabel link = new JLabel(
                "<html><span style='color:#CCCCCC;'>¿No tienes cuenta? </span>" +
                        "<span style='color:#4FC3F7;'><u>Registrate</u></span></html>");
        link.setFont(new Font("Arial", Font.PLAIN, 14));
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));

        link.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                new RegistroVisualUser().setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent evt) {
                link.setText(
                        "<html><span style='color:#CCCCCC;'>¿No tienes cuenta? </span>" +
                                "<span style='color:#64B5F6;'><u>Registrate</u></span></html>");
            }

            public void mouseExited(MouseEvent evt) {
                link.setText(
                        "<html><span style='color:#CCCCCC;'>¿No tienes cuenta? </span>" +
                                "<span style='color:#4FC3F7;'><u>Registrate</u></span></html>");
            }
        });

        return link;
    }

    private void setupListeners(JButton loginButton) {
        // Validación de solo números en cédula
        authPanel.usuarioField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        // Acción de login
        loginButton.addActionListener(e -> {
            String cedula = authPanel.usuarioField.getText().trim();
            String contrasenia = new String(authPanel.passField.getPassword());

            if (cedula.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, complete ambos campos.",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!Pattern.matches("^\\d+$", cedula)) {
                JOptionPane.showMessageDialog(this,
                        "La cédula debe contener solo números.",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            controlerLogin controlador = new controlerLogin();
            if (controlador.Validar(cedula, contrasenia)) {
                if (controlador.detectarRol()) {
                    new InicioVisualAdmin().setVisible(true);
                } else {
                    new InicioVisual().setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Cédula y/o contraseña incorrectos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginVisual());
    }
}