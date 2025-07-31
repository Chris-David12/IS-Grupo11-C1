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
    private ActionListener scanListener;

    public MenuCardAdmin(TarjetaMenu tarjeta, ActionListener editListener, ActionListener deleteListener, ActionListener scanListener) {
        this.tarjeta = tarjeta;
        this.editListener = editListener;
        this.deleteListener = deleteListener;
        this.scanListener = scanListener;
        initUI();
    }

    private void initUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(48, 43, 47));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(21, 174, 92), 2),
            new EmptyBorder(10, 10, 10, 10)));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
                

        contentPanel.add(Box.createVerticalGlue()); // Espacio arriba
        contentPanel.add(createLabel("ID: " + tarjeta.getId()));
        contentPanel.add(createLabel("Tipo: " + tarjeta.getTipo()));
        contentPanel.add(createLabel("Fecha: " + tarjeta.getFecha()));
        contentPanel.add(createLabel("Horario: " + tarjeta.getHorario()));
        contentPanel.add(createLabel("Se ofrece: " + tarjeta.getDescripcion()));
        contentPanel.add(createLabel("Cantidad de usuarios: " + tarjeta.getCantidadUsuarios()));
        contentPanel.add(createLabel("Constantes: " + tarjeta.getConstante() + " Bs", new Color(21, 174, 92)));
        contentPanel.add(createLabel("Variables: " + tarjeta.getVariable() + " Bs", new Color(255, 193, 7)));
        contentPanel.add(createLabel("CCB: " + tarjeta.getCCB() + " Bs", new Color(255, 87, 34)));
        contentPanel.add(Box.createVerticalGlue()); // Espacio abajo

        add(contentPanel, BorderLayout.CENTER); // Centra el contenido
        add(createButtonPanel());
    }

    private JLabel createLabel(String text) {
        return createLabel(text, Color.WHITE);
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el componente en el BoxLayout
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto dentro del JLabel
        return label;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        JButton btnEscaneo = new JButton("Escaneo");
        btnEscaneo.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnEscaneo.setBackground(new Color(33, 150, 243)); // Color azul
        btnEscaneo.setForeground(Color.WHITE);
        btnEscaneo.setFocusPainted(false);
        btnEscaneo.addActionListener(scanListener);

        panel.add(Box.createHorizontalGlue());
        panel.add(btnEditar);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(btnEscaneo); // Añade el nuevo botón
        panel.add(Box.createHorizontalStrut(10));
        panel.add(btnEliminar);
        panel.add(Box.createHorizontalGlue());

        return panel;
    }
}