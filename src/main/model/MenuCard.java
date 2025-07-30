package main.model;

import javax.swing.*;
import java.awt.*;

public class MenuCard extends JPanel {
    private JButton buyButton;

    public MenuCard(String tipo, String fecha, String horario, String descripcion, int cantidadUsuarios) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(48, 43, 47));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        setPreferredSize(new Dimension(300, 350));

        // Icono según tipo de menú
        String iconPath = "../assets/" + tipo.toLowerCase() + ".png";
        JLabel image = new JLabel(new ImageIcon(iconPath));
        image.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título con tipo y fecha
        JLabel title = new JLabel(tipo + " - " + fecha);
        title.setFont(new Font("Roboto", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Horario
        JLabel schedule = new JLabel("Horario: " + horario);
        schedule.setFont(new Font("Roboto", Font.PLAIN, 14));
        schedule.setForeground(new Color(200, 200, 200));
        schedule.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Descripción formateada
        JLabel description = new JLabel("<html><div style='text-align: center;'>" +
                formatDescription(descripcion) + "</div></html>");
        description.setFont(new Font("Roboto", Font.PLAIN, 14));
        description.setForeground(Color.LIGHT_GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Cantidad de usuarios
        JLabel usersLabel = new JLabel("Disponible para: " + cantidadUsuarios + " personas");
        usersLabel.setFont(new Font("Roboto", Font.ITALIC, 12));
        usersLabel.setForeground(new Color(180, 180, 180));
        usersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(image);
        add(Box.createVerticalStrut(10));
        add(title);
        add(schedule);
        add(Box.createVerticalStrut(10));
        add(description);
        add(Box.createVerticalStrut(5));
        add(usersLabel);

        // Botones de admin (ocultos por defecto)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buyButton = new JButton("Apartar");

        styleButton(buyButton);

        buttonPanel.add(buyButton);
        buttonPanel.add(Box.createHorizontalStrut(10));

        add(Box.createVerticalStrut(10));
        add(buttonPanel);
    }

    private String formatDescription(String desc) {
        // Reemplaza comas por saltos de línea para mejor presentación
        return desc.replace(",", "<br>");
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Roboto", Font.PLAIN, 12));
        button.setBackground(new Color(21, 174, 92));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
}