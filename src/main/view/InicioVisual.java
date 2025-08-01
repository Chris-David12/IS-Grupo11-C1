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
        setTitle("Inicio - Usuario");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));

        controlerInicioUser cLU = controlerInicioUser.getInstance();

        // Header
        HeaderPanel header = new HeaderPanel(cLU, false);
        add(header);

        // Menú title
        add(createMenuTitle());

        // Menu cards
        add(createUserMenuCards());

        // Logout action
        header.getLogoutButton().addActionListener(e -> logout());

        header.getExtraButton().addActionListener(e -> {
            new RecargarSaldoVisual().setVisible(true);
            dispose();
        });
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

        List<String[]> menusData = leerMenusDesdeArchivo();

        if (menusData.isEmpty()) {
            JLabel noMenusLabel = new JLabel("No hay menús disponibles actualmente");
            noMenusLabel.setForeground(Color.WHITE);
            noMenusLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
            container.add(noMenusLabel, BorderLayout.CENTER);
        } else {
            JPanel cardsPanel = new JPanel(new GridLayout(0, 3, 20, 20)); // 3 columnas
            cardsPanel.setOpaque(false);

            for (String[] menuData : menusData) {
                try {
                    MenuCard card = createMenuCard(menuData);
                    cardsPanel.add(card);
                } catch (Exception e) {
                    System.err.println("Error al crear tarjeta de menú: " + e.getMessage());
                }
            }

            JScrollPane scrollPane = new JScrollPane(cardsPanel);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());

            container.add(scrollPane, BorderLayout.CENTER);
        }

        return container;
    }

    private MenuCard createMenuCard(String[] menuData) {
        // Validar que tenemos los datos mínimos necesarios
        if (menuData.length < 5) {
            throw new IllegalArgumentException("Datos de menú incompletos");
        }

        String tipo = menuData[0].trim();
        String fecha = menuData[1].trim();
        String horario = menuData[2].trim();
        String descripcion = menuData[3].trim();
        int cantidadUsuarios = Integer.parseInt(menuData[4].trim());

        MenuCard card = new MenuCard(tipo, fecha, horario, descripcion, cantidadUsuarios);// Oculta botones de
                                                                                          // edición/eliminación

        // Estilo para usuario normal
        card.setBackground(new Color(60, 60, 60));
        card.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        card.setPreferredSize(new Dimension(300, 200));

        return card;
    }

    private List<String[]> leerMenusDesdeArchivo() {
        List<String[]> menus = new ArrayList<>();
        String filePath = "menuDataBase.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar encabezado si existe
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] menuData = line.split("\\|");
                    if (menuData.length >= 5) {
                        menus.add(menuData);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los menús: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }

        return menus;
    }

    private void logout() {
        controlerInicioUser.limpiarArchivoSesion();
        new LoginVisual().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InicioVisual frame = new InicioVisual();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}