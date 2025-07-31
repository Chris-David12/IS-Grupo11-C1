package main.model;

import javax.swing.*;
import java.awt.*;
import main.controller.controlerInicioUser;

public class HeaderPanel extends JPanel {
    private JButton logoutButton;
    private JButton extraButton; // <-- Agrega esto como atributo

    public HeaderPanel(controlerInicioUser cLU, boolean isAdmin) {
        setLayout(new BorderLayout());
        setBackground(new Color(39, 39, 39));
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Panel superior con color
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(21, 174, 92));
        topPanel.setPreferredSize(new Dimension(1280, 200));

        // Panel izquierdo con logo y texto
        topPanel.add(createLeftPanel(), BorderLayout.CENTER);

        // Panel derecho con botones
        topPanel.add(createRightPanel(cLU, isAdmin), BorderLayout.EAST);

        add(topPanel, BorderLayout.CENTER);
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);

        ImageIcon logoIcon = new ImageIcon(new ImageIcon("assets/logo.png")
                .getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH));

        JLabel logo = new JLabel(logoIcon);
        logo.setBounds(20, 25, 150, 150);
        panel.add(logo);

        JLabel welcome = new JLabel("Bienvenido al Comedor Estudiantil");
        welcome.setBounds(200, 40, 600, 100);
        welcome.setFont(new Font("Roboto Black", Font.BOLD, 30));
        welcome.setForeground(Color.WHITE);
        panel.add(welcome);

        JLabel phrase = new JLabel("De la casa que vence las sombras");
        phrase.setBounds(200, 100, 800, 50);
        phrase.setFont(new Font("Roboto", Font.PLAIN, 22));
        phrase.setForeground(Color.WHITE);
        panel.add(phrase);

        return panel;
    }

    private JPanel createRightPanel(controlerInicioUser cLU, boolean isAdmin) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 50));

        JLabel userLabel = new JLabel(cLU.usuario);
        userLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        userLabel.setForeground(Color.WHITE);

        if (!isAdmin) {
            JLabel balanceLabel = new JLabel("Saldo: " + cLU.saldo + " Bs");
            balanceLabel.setFont(new Font("Roboto", Font.BOLD, 18));
            balanceLabel.setForeground(Color.WHITE);
            panel.add(balanceLabel);
        }

        panel.add(userLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón adicional según el tipo de usuario
        String botonTexto = isAdmin ? "Escaneo Facial" : "Recargar Saldo";
        extraButton = new JButton(botonTexto); // <-- Ahora es el atributo de la claseAhora es el atributo de la clase
        extraButton.setFont(new Font("Roboto", Font.BOLD, 18));
        extraButton.setBackground(new Color(48, 43, 47));
        extraButton.setForeground(Color.WHITE);
        extraButton.setBorderPainted(false);
        extraButton.setFocusPainted(false);
        extraButton.setMaximumSize(new Dimension(200, 40));
        extraButton.setPreferredSize(new Dimension(200, 40));
        extraButton.setMinimumSize(new Dimension(200, 40));
        panel.add(extraButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        logoutButton = new JButton("CERRAR SESIÓN");
        logoutButton.setFont(new Font("Roboto", Font.BOLD, 18));
        logoutButton.setBackground(new Color(48, 43, 47));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorderPainted(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setMaximumSize(new Dimension(200, 40));
        logoutButton.setPreferredSize(new Dimension(200, 40));
        logoutButton.setMinimumSize(new Dimension(200, 40));

        panel.add(logoutButton);

        return panel;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getExtraButton() {
        return extraButton; 
    }
}