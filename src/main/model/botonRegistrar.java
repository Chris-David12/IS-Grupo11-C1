package main.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class botonRegistrar extends JButton {

    // Constructor
    public botonRegistrar() {
        super("registrar");
        configurarApariencia();
    }

    // Constructor con ActionListener
    public botonRegistrar(ActionListener listener) {
        this();
        this.addActionListener(listener);
    }

    // Configuracion de la apariencia del boton
    private void configurarApariencia() {
        this.setBackground(new Color(46, 125, 50));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Segoe UI", Font.BOLD, 14));
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(56, 142, 60));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(46, 125, 50));
            }
        });
    }

    // Texto del boton
    public void setButtonText(String text) {
        this.setText(text);
    }
}
