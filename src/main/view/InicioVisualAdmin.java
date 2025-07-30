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

        // Panel para el subtítulo alineado a la izquierda
        JPanel panelSubtitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSubtitulo.setBackground(new Color(39, 39, 39));
        panelSubtitulo.setPreferredSize(new Dimension(1280, 50));

        JLabel subtitulo = new JLabel("Gestor de  Menús");
        subtitulo.setFont(new Font("Roboto Black", Font.BOLD, 32));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo.add(subtitulo);

        // Agrega el panel del subtítulo debajo del panel superior
        add(contenedorSuperior);
        add(panelSubtitulo);

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                LoginVisual loginV = new LoginVisual();
                loginV.setVisible(true);
                dispose();
            }

        });

        // Panel contenedor general para las cartas
        JPanel panelCartasContenedor = new JPanel(new BorderLayout());
        panelCartasContenedor.setBackground(new Color(39, 39, 39));
        panelCartasContenedor.setBorder(new EmptyBorder(20, 50, 20, 50));

        // Panel interno con layout de tipo grid
        JPanel panelCartas = new JPanel();
        panelCartas.setLayout(new GridLayout(0, 4, 20, 20));
        panelCartas.setOpaque(false);

        // 🔹 Tarjetas tipo miniatura
        for (int i = 1; i <= 6; i++) {
            JPanel tarjeta = new JPanel();
            tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
            tarjeta.setBackground(new Color(48, 43, 47));
            tarjeta.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                    new EmptyBorder(10, 10, 10, 10)));

            // Imagen miniatura centrada
            JLabel miniatura = new JLabel(new ImageIcon("../assets/menu" + i + ".png"));
            miniatura.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(miniatura);
            tarjeta.add(Box.createVerticalStrut(10));

            // Título alineado a la izquierda
            JLabel titulo = new JLabel("Aqui va si es desayuno o almuerzo");
            titulo.setFont(new Font("Roboto", Font.BOLD, 18));
            titulo.setForeground(Color.WHITE);
            titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(titulo);

            // Fecha alineada a la izquierda
            JLabel fecha = new JLabel("Fecha: ");
            fecha.setFont(new Font("Roboto", Font.PLAIN, 14));
            fecha.setForeground(Color.LIGHT_GRAY);
            fecha.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(fecha);

            // Horario alineado a la izquierda
            JLabel horario = new JLabel("Horario:");
            horario.setFont(new Font("Roboto", Font.PLAIN, 14));
            horario.setForeground(Color.LIGHT_GRAY);
            horario.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(horario);

            // Descripción alineada a la izquierda
            JLabel descripcion = new JLabel("Se ofrece:");
            descripcion.setFont(new Font("Roboto", Font.PLAIN, 14));
            descripcion.setForeground(Color.LIGHT_GRAY);
            descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(descripcion);

            // Cantidad de usuarios alineado a la izquierda
            JLabel CantidadDeUsuarios = new JLabel("Cantidad de usuarios:");
            CantidadDeUsuarios.setFont(new Font("Roboto", Font.PLAIN, 14));
            CantidadDeUsuarios.setForeground(Color.LIGHT_GRAY);
            CantidadDeUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
            tarjeta.add(CantidadDeUsuarios);

            // Empuja los botones hacia abajo
            tarjeta.add(Box.createVerticalGlue());

            // Panel de botones centrado (como estaba)
            JPanel panelBotonesTarjeta = new JPanel();
            panelBotonesTarjeta.setLayout(new BoxLayout(panelBotonesTarjeta, BoxLayout.X_AXIS));
            panelBotonesTarjeta.setOpaque(false);

            JButton btnEditar = new JButton("Editar");
            btnEditar.setFont(new Font("Roboto", Font.PLAIN, 14));
            btnEditar.setBackground(new Color(21, 174, 92));
            btnEditar.setForeground(Color.WHITE);
            btnEditar.setFocusPainted(false);

            JButton btnEliminar = new JButton("Eliminar");
            btnEliminar.setFont(new Font("Roboto", Font.PLAIN, 14));
            btnEliminar.setBackground(new Color(174, 21, 21));
            btnEliminar.setForeground(Color.WHITE);
            btnEliminar.setFocusPainted(false);

            panelBotonesTarjeta.add(Box.createHorizontalGlue());
            panelBotonesTarjeta.add(btnEditar);
            panelBotonesTarjeta.add(Box.createHorizontalStrut(15)); // Separación entre botones
            panelBotonesTarjeta.add(btnEliminar);
            panelBotonesTarjeta.add(Box.createHorizontalGlue());

            tarjeta.add(Box.createVerticalStrut(10));
            tarjeta.add(panelBotonesTarjeta);

            panelCartas.add(tarjeta);
        }

        // Tarjeta para agregar nuevo menú
        JPanel tarjetaAgregar = new JPanel();
        tarjetaAgregar.setLayout(new BoxLayout(tarjetaAgregar, BoxLayout.Y_AXIS));
        tarjetaAgregar.setBackground(new Color(21, 101, 192)); // Azul
        tarjetaAgregar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                new EmptyBorder(10, 10, 10, 10)));

        // Icono "+" grande centrado
        JLabel iconoMas = new JLabel("+");
        iconoMas.setFont(new Font("Roboto", Font.BOLD, 60));
        iconoMas.setForeground(Color.WHITE);
        iconoMas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto debajo del icono
        JLabel textoAgregar = new JLabel("Agregar menú");
        textoAgregar.setFont(new Font("Roboto", Font.BOLD, 18));
        textoAgregar.setForeground(Color.WHITE);
        textoAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);

        tarjetaAgregar.add(Box.createVerticalGlue());
        tarjetaAgregar.add(iconoMas);
        tarjetaAgregar.add(Box.createVerticalStrut(10));
        tarjetaAgregar.add(textoAgregar);
        tarjetaAgregar.add(Box.createVerticalGlue());

        // Opcional: Cambia el cursor al pasar el mouse
        tarjetaAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Opcional: Añade un MouseListener para manejar el click
        tarjetaAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Aquí puedes abrir el formulario para agregar un nuevo menú
                JOptionPane.showMessageDialog(null, "Agregar nuevo menú");
            }
        });

        panelCartas.add(tarjetaAgregar);

        panelCartasContenedor.add(panelCartas, BorderLayout.CENTER);

        // Agrega el panel de cartas justo después del subtítulo
        add(panelCartasContenedor);

        // Elimina las líneas:
        // add(panelSubtitulo, BorderLayout.CENTER);
        // add(panelCartasContenedor, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InicioVisualAdmin().setVisible(true);
        });
    }

}