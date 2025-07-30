import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.controller.controlerInicioUser;
import main.model.TarjetaMenu;
import main.model.HeaderPanel;
import main.model.AddMenuCard;
import main.model.MenuCardAdmin;
import main.model.MenuEditorDialog;

public class InicioVisualAdmin extends JFrame {
    private List<TarjetaMenu> tarjetas = new ArrayList<>();
    private JPanel panelCartas;
    private int nextId = 1;

    public InicioVisualAdmin() {
        configureWindow();
        initUI();
        loadSampleData();
    }

    private void configureWindow() {
        setTitle("Inicio - Administrador");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));
    }

    private void initUI() {
        controlerInicioUser cLU = new controlerInicioUser();

        // Header
        HeaderPanel header = new HeaderPanel(cLU, true);
        add(header);

        // Configurar botón de logout
        header.getLogoutButton().addActionListener(e -> logout());

        // Título
        add(createTitlePanel("Gestor de Menús"));

        // Panel de tarjetas
        JPanel cardsContainer = new JPanel(new BorderLayout());
        cardsContainer.setBackground(new Color(39, 39, 39));
        cardsContainer.setBorder(new EmptyBorder(20, 50, 20, 50));

        panelCartas = new JPanel();
        panelCartas.setLayout(new GridLayout(0, 4, 20, 20));
        panelCartas.setOpaque(false);

        cardsContainer.add(panelCartas, BorderLayout.CENTER);
        add(cardsContainer);

        refreshCards();
    }

    /**
     * Método para cerrar sesión:
     * 1. Limpia el archivo de sesión
     * 2. Abre la ventana de login
     * 3. Cierra la ventana actual
     */
    private void logout() {
        // Limpiar el archivo de sesión
        controlerInicioUser.limpiarArchivoSesion();

        // Abrir ventana de login
        new LoginVisual().setVisible(true);

        // Cerrar ventana actual
        dispose();
    }

    private JPanel createTitlePanel(String titleText) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(39, 39, 39));
        panel.setPreferredSize(new Dimension(1280, 50));

        JLabel title = new JLabel(titleText);
        title.setFont(new Font("Roboto Black", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(0, 50, 0, 0));
        panel.add(title);

        return panel;
    }

    private void loadSampleData() {
        tarjetas.clear(); // Limpiar lista existente
        File file = new File("menuDataBase.txt");

        try {
            if (!file.exists()) {
                // Si el archivo no existe, crear uno con datos de ejemplo
                file.createNewFile();
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println("tipo|fecha|horario|descripcion|cantidadUsuarios|constante|variable");
                    writer.println("Desayuno|2025-07-29|07:00-09:00|Café y pan|50|100.0|50.0");
                    writer.println("Almuerzo|2025-07-29|12:00-14:00|Sopa y segundo|80|120.0|60.0");
                }
            }

            // Leer datos del archivo
            try (Scanner scanner = new Scanner(file)) {
                // Saltar la primera línea (encabezados)
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        String[] parts = line.split("\\|");
                        if (parts.length == 7) { // Ahora son 7 campos en lugar de 8
                            TarjetaMenu menu = new TarjetaMenu(
                                    nextId++, // Generamos nuevo ID automáticamente
                                    parts[0], // tipo
                                    parts[1], // fecha
                                    parts[2], // horario
                                    parts[3], // descripcion
                                    Integer.parseInt(parts[4]), // cantidadUsuarios
                                    Double.parseDouble(parts[5]), // constante
                                    Double.parseDouble(parts[6]) // variable
                            );
                            tarjetas.add(menu);
                        }
                    }
                }
            }

            // Actualizar la interfaz gráfica después de cargar los datos
            refreshCards();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al leer/escribir el archivo de menús: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Error en el formato de los datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveMenuData() {
        try (PrintWriter writer = new PrintWriter("menuDataBase.txt")) {
            writer.println("tipo|fecha|horario|descripcion|cantidadUsuarios|constante|variable");

            for (TarjetaMenu menu : tarjetas) {
                writer.println(String.join("|",
                        menu.getTipo(),
                        menu.getFecha(),
                        menu.getHorario(),
                        menu.getDescripcion(),
                        String.valueOf(menu.getCantidadUsuarios()),
                        String.valueOf(menu.getConstante()),
                        String.valueOf(menu.getVariable())));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar los menús: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshCards() {
        panelCartas.removeAll();

        // Tarjetas de menú existentes
        for (TarjetaMenu t : tarjetas) {
            panelCartas.add(new MenuCardAdmin(t,
                    e -> editTarjeta(t),
                    e -> deleteTarjeta(t)));
        }

        // Tarjeta para agregar nuevo menú
        panelCartas.add(new AddMenuCard(this::addTarjeta));

        panelCartas.revalidate();
        panelCartas.repaint();
    }

    private void editTarjeta(TarjetaMenu tarjeta) {
        TarjetaMenu edited = MenuEditorDialog.showDialog(this, tarjeta);
        if (edited != null) {
            // Mantenemos el mismo ID, solo actualizamos los demás campos
            tarjeta.setTipo(edited.getTipo());
            tarjeta.setFecha(edited.getFecha());
            tarjeta.setHorario(edited.getHorario());
            tarjeta.setDescripcion(edited.getDescripcion());
            tarjeta.setCantidadUsuarios(edited.getCantidadUsuarios());
            tarjeta.setConstante(edited.getConstante());
            tarjeta.setVariable(edited.getVariable());
            refreshCards();
            saveMenuData(); // Guardar cambios en el archivo
        }
    }

    private void deleteTarjeta(TarjetaMenu tarjeta) {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este menú?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            tarjetas.remove(tarjeta);
            refreshCards();
            saveMenuData(); // Guardar cambios en el archivo
        }
    }

    private void addTarjeta() {
        TarjetaMenu nueva = MenuEditorDialog.showDialog(this, null);
        if (nueva != null) {
            nueva.setId(nextId++);
            tarjetas.add(nueva);
            refreshCards();
            saveMenuData(); // Guardar cambios en el archivo
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InicioVisualAdmin().setVisible(true));
    }
}