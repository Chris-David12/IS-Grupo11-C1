
import javax.swing.*;
import java.awt.*;
import main.controller.controlerInicioUser;
import main.model.HeaderPanel;
import main.model.MenuCard;

public class InicioVisual extends JFrame {
    public InicioVisual() {
        setTitle("Inicio");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));

        controlerInicioUser cLU = new controlerInicioUser();

        // Header
        HeaderPanel header = new HeaderPanel(cLU, false);
        add(header);

        // Menú title
        add(createMenuTitle());

        // Menu cards
        add(createMenuCards());

        // Logout action
        header.getLogoutButton().addActionListener(e -> logout());
    }

    private JPanel createMenuTitle() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(39, 39, 39));

        JLabel title = new JLabel("MENÚS DISPONIBLES");
        title.setFont(new Font("Roboto Black", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        panel.add(title);

        return panel;
    }

    private JPanel createMenuCards() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(39, 39, 39));
        container.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel cards = new JPanel();
        cards.setLayout(new GridLayout(0, 4, 20, 20));
        cards.setOpaque(false);

        for (int i = 1; i <= 6; i++) {
            cards.add(new MenuCard(i));
        }

        container.add(cards, BorderLayout.CENTER);
        return container;
    }

    private void logout() {
        controlerInicioUser.limpiarArchivoSesion();
        new LoginVisual().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InicioVisual().setVisible(true));
    }
}