
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import main.model.ImagePanel;
import main.model.RegisterForm;



public class RegistroVisualUser extends JFrame {
    private RegisterForm registerForm;

    public RegistroVisualUser() {
        setTitle("Comedor Estudiantil - Registro Usuario");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo con imagen
        ImagePanel leftPanel = new ImagePanel("assets/comedor(2).jpeg", 1.0f);
        leftPanel.addLogo();

        // Panel derecho con formulario
        JPanel rightPanel = createRightPanel();

        // Split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(39, 39, 39));

        // Título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(119, 182, 201));
        titlePanel.setPreferredSize(new Dimension(0, 90));

        JLabel title = new JLabel("CREAR CUENTA");
        title.setFont(new Font("Roboto Black", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        titlePanel.add(title);
        panel.add(titlePanel, BorderLayout.NORTH);

        // Formulario
        registerForm = new RegisterForm();
        JScrollPane scrollPane = new JScrollPane(registerForm);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Configurar listener
        registerForm.setRegisterListener(this::handleRegister);

        // Agregar enlace a login
        addLoginLink(panel);

        return panel;
    }

    private void addLoginLink(JPanel panel) {
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        linkPanel.setBackground(new Color(39, 39, 39));
        linkPanel.setBorder(new EmptyBorder(10, 0, 20, 0));

        JLabel loginLink = new JLabel(
                "<html><span style='color:#CCCCCC;'>¿Ya tienes cuenta? Haz click </span>" +
                        "<span style='color:#4FC3F7;'><u>aquí</u></span></html>");
        loginLink.setFont(new Font("Arial", Font.PLAIN, 14));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new LoginVisual().setVisible(true);
                dispose();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginLink.setText(
                        "<html><span style='color:#CCCCCC;'>¿Ya tienes cuenta? Haz click </span>" +
                                "<span style='color:#64B5F6;'><u>aquí</u></span></html>");
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginLink.setText(
                        "<html><span style='color:#CCCCCC;'>¿Ya tienes cuenta? Haz click </span>" +
                                "<span style='color:#4FC3F7;'><u>aquí</u></span></html>");
            }
        });

        linkPanel.add(loginLink);
        panel.add(linkPanel, BorderLayout.SOUTH);
    }

    private void handleRegister(ActionEvent e) {
        if (registerForm.validateFields()) {
            if (registerForm.registerUser()) {
                new LoginVisual().setVisible(true);
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroVisualUser());
    }
}