package main.view;

import javax.swing.*;

import main.controler.controleRegister;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroVisual extends JFrame {

    public RegistroVisual() {
        setTitle("Comedor Estudiantil");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 👉 Panel izquierdo: fondo + logo + título
        JPanel panelIzquierdo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // 🔧 Dibujar imagen de fondo
                ImageIcon fondo = new ImageIcon("assets/comedor(2).jpeg");
                g2d.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

                // 🌫️ Dibujar capa semi-transparente encima
                g2d.setColor(new Color(16, 198, 90, 120)); // RGBA → negro con transparencia
                g2d.fillRect(0, 0, getWidth(), getHeight());        
            }
        };
        panelIzquierdo.setPreferredSize(new Dimension(640, 720));
        panelIzquierdo.setLayout(null);

        // Tamaño deseado para el logo (más grande)
        ImageIcon iconoOriginal = new ImageIcon("assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // Aumenta tamaño
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);

        // Logo centrado
        JLabel logo = new JLabel(iconoFinal);
        logo.setBounds(195, 130, 250, 250); // Centrado horizontal y más abajo
        panelIzquierdo.add(logo);

        // Nombre del sistema centrado y más grande
        JLabel nombreSistema = new JLabel("COMEDOR ESTUDIANTIL");
        nombreSistema.setBounds(70, 400, 500, 60); // Centrado y más ancho/alto
        nombreSistema.setFont(new Font("Roboto Black", Font.BOLD, 34)); // Aumenta tamaño de fuente
        nombreSistema.setForeground(Color.WHITE);
        nombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
        panelIzquierdo.add(nombreSistema);

        // 👉 Panel derecho: formulario
        JPanel panelDerecho = new JPanel();
        panelDerecho.setPreferredSize(new Dimension(640, 720));
        panelDerecho.setBackground(new Color(39, 39, 39));
        panelDerecho.setLayout(null);

        // Panel de color para el título (mismo ancho que panelDerecho)
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 640, 90);
        panelTitulo.setBackground(new Color(119, 182, 201));
        panelTitulo.setLayout(null);
        panelDerecho.add(panelTitulo);

        // Título encima del panel de color, centrado
        JLabel title = new JLabel("CREAR CUENTA");
        title.setBounds(0, 0, 640, 90);
        title.setFont(new Font("Roboto Black", Font.BOLD, 36));
        title.setForeground(new Color(255, 255, 255));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        panelTitulo.add(title);

        // Campos de usuario
        JLabel usuarioLabel = new JLabel("NOMBRE Y APELLIDO:");
        usuarioLabel.setBounds(120, 120, 400, 35);
        usuarioLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        usuarioLabel.setForeground(new Color(255, 255, 255));
        panelDerecho.add(usuarioLabel);

        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(120, 160, 400, 35);
        panelDerecho.add(usuarioField);
        usuarioField.setBackground(new Color(96, 96, 96));
        usuarioField.setForeground(Color.WHITE);

        // Campos de Cedula
        JLabel cedulaLabel = new JLabel("CÉDULA:");
        cedulaLabel.setBounds(120, 210, 400, 35);
        cedulaLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        cedulaLabel.setForeground(new Color(255, 255, 255));
        panelDerecho.add(cedulaLabel);

        JTextField cedulaField = new JTextField();
        cedulaField.setBounds(120, 250, 400, 35);
        panelDerecho.add(cedulaField);
        cedulaField.setBackground(new Color(96, 96, 96));
        cedulaField.setForeground(Color.WHITE);

        // Campos de correo electrónico
        JLabel emailLabel = new JLabel("CORREO ELECTRÓNICO:");
        emailLabel.setBounds(120, 300, 400, 35);
        emailLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        emailLabel.setForeground(new Color(255, 255, 255));
        panelDerecho.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 340, 400, 35);
        panelDerecho.add(emailField);
        emailField.setBackground(new Color(96, 96, 96));
        emailField.setForeground(Color.WHITE);

        // Campos de contraseña
        JLabel passLabel = new JLabel("CONTRASEÑA:");
        passLabel.setBounds(120, 390, 400, 35);
        passLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        passLabel.setForeground(new Color(255, 255, 255));
        panelDerecho.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 430, 400, 35);
        panelDerecho.add(passField);
        passField.setBackground(new Color(96, 96, 96));
        passField.setForeground(Color.WHITE);

        // Confirmar contraseña
        JLabel confirmPassLabel = new JLabel("CONFIRMAR CONTRASEÑA:");
        confirmPassLabel.setBounds(120, 480, 400, 35);
        confirmPassLabel.setFont(new Font("Roboto Light", Font.BOLD, 20));
        confirmPassLabel.setForeground(new Color(255, 255, 255));
        panelDerecho.add(confirmPassLabel);

        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setBounds(120, 520, 400, 35);
        panelDerecho.add(confirmPassField);
        confirmPassField.setBackground(new Color(96, 96, 96));
        confirmPassField.setForeground(Color.WHITE);

        // Botón de registro
        JButton entrarButton = new JButton("Entrar");
        entrarButton.setBounds(260, 600, 120, 45);
        entrarButton.setBackground(new Color(70, 130, 180));
        entrarButton.setForeground(Color.WHITE);
        entrarButton.setFont(new Font("Arial", Font.BOLD, 20));
        panelDerecho.add(entrarButton);

        // Texto pequeño sobre el botón
        JLabel cuentaLabel = new JLabel(
            "<html><span style='color:#CCCCCC;'>¿Ya tienes una cuenta? Haz click </span>" +
            "<span style='color:#4FC3F7;'><u>aquí</u></span></html>"
        );
        cuentaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cuentaLabel.setBounds(220, 570, 220, 25); // Centrado sobre el botón
        cuentaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelDerecho.add(cuentaLabel);

        controleRegister R = new controleRegister();

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!R.Validar(cedulaField.getText())){
                R.Registrar(cedulaField.getText(),usuarioField.getText(),emailField.getText(),passField.getText());

                String user = usuarioField.getText();
               }else{

               }
            }
        });

        // Agregar los paneles a la ventana principal
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistroVisual();
    }
}
