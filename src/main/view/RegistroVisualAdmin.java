
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import main.model.ImagePanel;
import main.model.RegisterForm;

public class RegistroVisualAdmin extends JFrame {
    private RegisterForm registerForm;

    public RegistroVisualAdmin() {
        setTitle("Comedor Estudiantil - Registro Admin");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel izquierdo con imagen
        ImagePanel leftPanel = new ImagePanel("../assets/comedor(2).jpeg", 1.0f);
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

        JLabel title = new JLabel("CREAR CUENTA ADMIN");
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

        return panel;
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
        SwingUtilities.invokeLater(() -> new RegistroVisualAdmin());
    }
}