package main.model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMenuCard extends JPanel {
    public AddMenuCard(Runnable onClick) {
        initUI(onClick);
    }

    private void initUI(Runnable onClick) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(21, 101, 192));
        setBorder(BorderFactory.createCompoundBorder(
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

        add(Box.createVerticalGlue());
        add(iconoMas);
        add(Box.createVerticalStrut(10));
        add(textoAgregar);
        add(Box.createVerticalGlue());

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick.run();
            }
        });
    }
}