import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

        // Menu cards - versión usuario normal
        add(createUserMenuCards());

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

    private JPanel createUserMenuCards() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(new Color(39, 39, 39));
        container.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JPanel cards = new JPanel();
        cards.setLayout(new GridLayout(0, 4, 20, 20));
        cards.setOpaque(false);

        // Obtener menús desde el archivo
        List<String[]> menusData = leerMenusDesdeArchivo();

        for (String[] menuData : menusData) {
            // Crear tarjeta con los datos del menú
            MenuCard card = new MenuCard(
                    Integer.parseInt(menuData[4]) // cantidadUsuarios
            );
            card.hideAdminButtons(); // Ocultar botones de admin
            cards.add(card);
        }

        // Scroll por si hay muchos menús
        JScrollPane scrollPane = new JScrollPane(cards);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        container.add(scrollPane, BorderLayout.CENTER);
        return container;
    }

    private List<String[]> leerMenusDesdeArchivo() {
        List<String[]> menus = new ArrayList<>();
        String filePath = "menuDataBase.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea por el caracter "|"
                String[] menuData = line.split("\\|");
                if (menuData.length >= 5) { // Asegurarse que tiene los campos mínimos
                    menus.add(menuData);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los menús: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return menus;
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