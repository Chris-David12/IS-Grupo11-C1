package main.model;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private String imagePath;
    private float opacity;

    public ImagePanel(String imagePath, float opacity) {
        this.imagePath = imagePath;
        this.opacity = opacity;
        setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon fondo = new ImageIcon(imagePath);
        g2d.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        g2d.setColor(new Color(16, 198, 90, (int) (120 * opacity)));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public void addLogo() {
        ImageIcon icono = new ImageIcon("assets/logo.png");
        Image imagen = icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(new JLabel(new ImageIcon(imagen)), gbc);

        JLabel title = new JLabel("COMEDOR ESTUDIANTIL");
        title.setFont(new Font("Roboto Black", Font.BOLD, 34));
        title.setForeground(Color.WHITE);
        gbc.gridy = 1;
        add(title, gbc);
    }
}