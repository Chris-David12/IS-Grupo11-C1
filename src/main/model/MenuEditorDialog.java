package main.model;

import javax.swing.*;
import java.awt.*;
import main.model.TarjetaMenu;

public class MenuEditorDialog {
    public static TarjetaMenu showDialog(Component parent, TarjetaMenu tarjetaExistente) {
        JTextField tipoField = new JTextField();
        JTextField fechaField = new JTextField();
        JTextField horarioField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField cantidadUsuariosField = new JTextField();
        JTextField constanteField = new JTextField();
        JTextField variableField = new JTextField();

        if (tarjetaExistente != null) {
            tipoField.setText(tarjetaExistente.getTipo());
            fechaField.setText(tarjetaExistente.getFecha());
            horarioField.setText(tarjetaExistente.getHorario());
            descripcionField.setText(tarjetaExistente.getDescripcion());
            cantidadUsuariosField.setText(String.valueOf(tarjetaExistente.getCantidadUsuarios()));
            constanteField.setText(String.valueOf(tarjetaExistente.getConstante()));
            variableField.setText(String.valueOf(tarjetaExistente.getVariable()));
        }

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Tipo:"));
        panel.add(tipoField);
        panel.add(new JLabel("Fecha:"));
        panel.add(fechaField);
        panel.add(new JLabel("Horario:"));
        panel.add(horarioField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Cantidad de usuarios:"));
        panel.add(cantidadUsuariosField);
        panel.add(new JLabel("Constantes:"));
        panel.add(constanteField);
        panel.add(new JLabel("Variables:"));
        panel.add(variableField);

        int result = JOptionPane.showConfirmDialog(parent, panel,
                tarjetaExistente != null ? "Editar Menú" : "Agregar Menú",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = tarjetaExistente != null ? tarjetaExistente.getId() : 0;
                return new TarjetaMenu(
                        id,
                        tipoField.getText(),
                        fechaField.getText(),
                        horarioField.getText(),
                        descripcionField.getText(),
                        Integer.parseInt(cantidadUsuariosField.getText()),
                        Double.parseDouble(constanteField.getText()),
                        Double.parseDouble(variableField.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Datos inválidos.");
                return null;
            }
        }
        return null;
    }
}