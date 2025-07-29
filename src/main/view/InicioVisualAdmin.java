import javax.swing.*;
import java.awt.*;

import main.controller.controlerInicioUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class InicioVisualAdmin extends JFrame {

    public InicioVisualAdmin() {
        setTitle("Inicio");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cambia el layout principal a BoxLayout en Y
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));

        // panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setPreferredSize(new Dimension(1280, 200));
        panelSuperior.setMinimumSize(new Dimension(0, 200));
        panelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        panelSuperior.setBackground(new Color(21, 174, 92));
        panelSuperior.setLayout(null);

        // Panel contenedor con margen para el panel superior
        JPanel contenedorSuperior = new JPanel(new BorderLayout());
        contenedorSuperior.setBackground(new Color(39, 39, 39));
        contenedorSuperior.setBorder(new EmptyBorder(10, 15, 10, 15)); // top, left, bottom, right
        contenedorSuperior.setPreferredSize(new Dimension(1280, 220)); // 200 + 2*10 de margen
        contenedorSuperior.setMinimumSize(new Dimension(0, 220));
        contenedorSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));

        contenedorSuperior.add(panelSuperior, BorderLayout.CENTER);

        // Logo pocision izquierda panel superior
        ImageIcon iconoOriginal = new ImageIcon("../assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
        JLabel logo = new JLabel(iconoFinal);
        logo.setBounds(20, 25, 150, 150);
        panelSuperior.add(logo);

        // bienvenida
        JLabel bienvenida = new JLabel("Bienvenido al Comedor Estudiantil");
        bienvenida.setBounds(200, 40, 600, 100);
        bienvenida.setFont(new Font("Roboto Black", Font.BOLD, 30));
        bienvenida.setForeground(Color.WHITE);
        bienvenida.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(bienvenida);

        // Frase inspiradora
        JLabel frase = new JLabel("De la casa que vence las sombras");
        frase.setBounds(200, 100, 800, 50);
        frase.setFont(new Font("Roboto", Font.PLAIN, 22));
        frase.setForeground(Color.WHITE);
        frase.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(frase);

        // Cambia el layout del panel superior a BorderLayout
        panelSuperior.setLayout(new BorderLayout());

        // Panel para logo y textos (izquierda)
        JPanel panelIzquierda = new JPanel(null);
        panelIzquierda.setOpaque(false);
        panelIzquierda.setPreferredSize(new Dimension(900, 200));
        // Logo
        logo = new JLabel(iconoFinal);
        logo.setBounds(20, 25, 150, 150);
        panelIzquierda.add(logo);
        // Bienvenida
        bienvenida = new JLabel("Bienvenido al Comedor Estudiantil");
        bienvenida.setBounds(200, 40, 600, 100);
        bienvenida.setFont(new Font("Roboto Black", Font.BOLD, 30));
        bienvenida.setForeground(Color.WHITE);
        bienvenida.setHorizontalAlignment(SwingConstants.LEFT);
        panelIzquierda.add(bienvenida);
        // Frase
        frase = new JLabel("De la casa que vence las sombras");
        frase.setBounds(200, 100, 800, 50);
        frase.setFont(new Font("Roboto", Font.PLAIN, 22));
        frase.setForeground(Color.WHITE);
        frase.setHorizontalAlignment(SwingConstants.LEFT);
        panelIzquierda.add(frase);

        panelSuperior.add(panelIzquierda, BorderLayout.CENTER);

        // Panel para los botones (derecha)
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(new EmptyBorder(60, 0, 0, 50)); // 50px margen derecho

        controlerInicioUser cLU = new controlerInicioUser();

        JButton NameAdmin = new JButton(cLU.usuario);
        NameAdmin.setFont(new Font("Roboto", Font.BOLD, 18));
        NameAdmin.setBackground(new Color(21, 174, 92));
        NameAdmin.setForeground(Color.WHITE);
        NameAdmin.setBorderPainted(false);
        NameAdmin.setFocusPainted(false);
        NameAdmin.setMaximumSize(new Dimension(200, 40));
        NameAdmin.setPreferredSize(new Dimension(200, 40));
        NameAdmin.setMinimumSize(new Dimension(200, 40));

        JButton botonLogin = new JButton("CERRAR SESIÓN");
        botonLogin.setFont(new Font("Roboto", Font.BOLD, 18));
        botonLogin.setBackground(new Color(48, 43, 47));
        botonLogin.setForeground(Color.WHITE);
        botonLogin.setBorderPainted(false);
        botonLogin.setFocusPainted(false);
        botonLogin.setMaximumSize(new Dimension(200, 40));
        botonLogin.setPreferredSize(new Dimension(200, 40));
        botonLogin.setMinimumSize(new Dimension(200, 40));

        panelBotones.add(NameAdmin);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10))); // separación vertical
        panelBotones.add(botonLogin);

        panelSuperior.add(panelBotones, BorderLayout.EAST);

        // SUBTiTULO 1 - Costos Fijos
        JPanel panelSubtitulo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSubtitulo1.setBackground(new Color(39, 39, 39));
        panelSubtitulo1.setPreferredSize(new Dimension(1280, 250));
        JLabel subtitulo1 = new JLabel("Costos Fijos");
        subtitulo1.setFont(new Font("Roboto Black", Font.BOLD, 32));
        subtitulo1.setForeground(Color.WHITE);
        subtitulo1.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo1.add(subtitulo1);

        // Tarjeta Costos Fijos
        JPanel carta1 = new JPanel(new BorderLayout());
        carta1.setBackground(new Color(48, 43, 47));
        carta1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        carta1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                new EmptyBorder(10, 15, 10, 15)));
        JLabel textoCarta1 = new JLabel(
                "<html><body style='width:1000px'>Los costos fijos incluyen alquiler, salarios fijos, y servicios básicos que no varían con la producción.</body></html>");
        textoCarta1.setFont(new Font("Roboto", Font.PLAIN, 18));
        textoCarta1.setForeground(Color.WHITE);
        carta1.add(textoCarta1, BorderLayout.CENTER);

        panelSubtitulo1.add(carta1);

        // SUBTiTULO 2 - Costos Variables
        JPanel panelSubtitulo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSubtitulo2.setBackground(new Color(39, 39, 39));
        panelSubtitulo2.setPreferredSize(new Dimension(1280, 250));
        JLabel subtitulo2 = new JLabel("Costos Variables");
        subtitulo2.setFont(new Font("Roboto Black", Font.BOLD, 32));
        subtitulo2.setForeground(Color.WHITE);
        subtitulo2.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo2.add(subtitulo2);

        // Tarjeta Costos Variables
        JPanel carta2 = new JPanel(new BorderLayout());
        carta2.setBackground(new Color(48, 43, 47));
        carta2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        carta2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                new EmptyBorder(10, 15, 10, 15)));
        JLabel textoCarta2 = new JLabel(
                "<html><body style='width:1000px'>Los costos variables son aquellos que cambian según el nivel de producción, como insumos y energía.</body></html>");
        textoCarta2.setFont(new Font("Roboto", Font.PLAIN, 18));
        textoCarta2.setForeground(Color.WHITE);
        carta2.add(textoCarta2, BorderLayout.CENTER);

        panelSubtitulo2.add(carta2);

        // Agregamos todo al contenedor principal
        add(contenedorSuperior);
        add(panelSubtitulo1);
        add(panelSubtitulo2);

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el archivo de sesión antes de cerrar
                controlerInicioUser.limpiarArchivoSesion();

                // Abrir la ventana de login
                LoginVisual loginV = new LoginVisual();
                loginV.setVisible(true);

                // Cerrar la ventana actual
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InicioVisualAdmin().setVisible(true);
        });
    }

}