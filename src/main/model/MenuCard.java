package main.model;

import javax.swing.*;
import java.awt.*;

public class MenuCard extends JPanel {
    public MenuCard(String menuData, String menuData2, String menuData3, String menuData4, int menuNumber) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(48, 43, 47));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JLabel image = new JLabel(new ImageIcon("../assets/menu" + menuNumber + ".png"));
        image.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Menú Día " + menuNumber);
        title.setFont(new Font("Roboto", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel(
                "<html><div style='text-align: center;'>Plato principal<br>Bebida<br>Postre</div></html>");
        description.setFont(new Font("Roboto", Font.PLAIN, 14));
        description.setForeground(Color.LIGHT_GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(image);
        add(Box.createVerticalStrut(10));
        add(title);
        add(Box.createVerticalStrut(5));
        add(description);
    }
}