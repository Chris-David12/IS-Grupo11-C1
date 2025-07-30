package main.model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import main.model.TarjetaMenu;
import java.awt.event.ActionListener;

public class MenuCardAdmin extends JPanel {
    private TarjetaMenu tarjeta;
    private ActionListener editListener;
    private ActionListener deleteListener;

    public MenuCardAdmin(TarjetaMenu tarjeta, ActionListener editListener, ActionListener deleteListener) {
        this.tarjeta = tarjeta;
        this.editListener = editListener;
        this.deleteListener = deleteListener;
        initUI();
    }

    private void initUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(48, 43, 47));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
                new EmptyBorder(10, 10, 10, 10)));

        add(createLabel("ID: " + tarjeta.getId()));
        add(createLabel("Tipo: " + tarjeta.getTipo()));
        add(createLabel("Fecha: " + tarjeta.getFecha()));
        add(createLabel("Horario: " + tarjeta.getHorario()));
        add(createLabel("Se ofrece: " + tarjeta.getDescripcion()));
        add(createLabel("Cantidad de usuarios: " + tarjeta.getCantidadUsuarios()));

        // Costos
        add(createLabel("Constantes: " + tarjeta.getConstante() + " Bs", new Color(21, 174, 92)));
        add(createLabel("Variables: " + tarjeta.getVariable() + " Bs", new Color(255, 193, 7)));
        add(createLabel("CCB: " + tarjeta.getCCB() + " Bs", new Color(255, 87, 34)));

        add(Box.createVerticalGlue());
        add(createButtonPanel());
    }

    private JLabel createLabel(String text) {
        return createLabel(text, Color.WHITE);
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        return label;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnEditar.setBackground(new Color(21, 174, 92));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(editListener);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnEliminar.setBackground(new Color(174, 21, 21));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(deleteListener);

        panel.add(Box.createHorizontalGlue());
        panel.add(btnEditar);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(btnEliminar);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }
}