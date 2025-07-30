package main.model;

import javax.swing.*;
import java.awt.*;

public class AuthPanel extends JPanel {
    public JTextField usuarioField;
    protected JTextField cedulaField;
    protected JTextField emailField;
    public JPasswordField passField;
    protected JPasswordField confirmPassField;

    public AuthPanel() {
        setBackground(new Color(39, 39, 39));
        setLayout(new GridBagLayout());
    }

    public void addFormField(GridBagConstraints gbc, String labelText, JComponent field) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Roboto Light", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        gbc.gridy++;
        add(label, gbc);

        field.setBackground(new Color(96, 96, 96));
        field.setForeground(Color.WHITE);
        field.setPreferredSize(new Dimension(500, 30));

        gbc.gridy++;
        add(field, gbc);
    }

    public JButton createRoundedButton(String text) {
        return new RoundedButton(text);
    }
}