package main.view;

import javax.swing.*;

import main.model.botonRegistrar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Vista Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel etiqueta = new JLabel("Nombre:");
        JTextField campoTexto = new JTextField(20);
        JButton boton = new JButton("Prueba");
        botonRegistrar registro = new botonRegistrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Registro exitoso");
            }
        });
        JLabel prueba = new JLabel("");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prueba.setText("HOLA " + campoTexto.getText() + "!");
            }
        });

        panel.add(etiqueta);
        panel.add(campoTexto);
        panel.add(boton);
        panel.add(registro);
        panel.add(prueba);

        frame.add(panel);
        frame.setVisible(true);
    }
}