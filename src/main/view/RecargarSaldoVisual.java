import javax.swing.*;
import java.awt.*;

import main.controller.controlerInicioUser;
import main.model.AuthPanel;
import main.model.RoundedButton;
import main.model.RoundedPasswordField;
import main.model.RoundedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class RecargarSaldoVisual extends JFrame {
    private AuthPanel authPanel;

    controlerInicioUser cLU = null;
    

    public RecargarSaldoVisual() {
        setTitle("Recargar Saldo - Comedor Estudiantil");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cambia el layout principal a BoxLayout en Y
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));

        // panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setPreferredSize(new Dimension(1280, 200));
        panelSuperior.setMinimumSize(new Dimension(0, 200));
        panelSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        panelSuperior.setBackground(new Color(21, 174, 92));
        panelSuperior.setLayout(null);

        // Panel contenedor con margen para el panel superior
        JPanel contenedorSuperior = new JPanel(new BorderLayout());
        contenedorSuperior.setBackground(new Color(39, 39, 39));
        contenedorSuperior.setBorder(new EmptyBorder(10, 15, 10, 15)); // top, left, bottom, right
        contenedorSuperior.setPreferredSize(new Dimension(1280, 220)); // 200 + 2*10 de margen
        contenedorSuperior.setMinimumSize(new Dimension(0, 220));
        contenedorSuperior.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));

        contenedorSuperior.add(panelSuperior, BorderLayout.CENTER);

        // Logo pocision izquierda panel superior
        ImageIcon iconoOriginal = new ImageIcon("../assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
        JLabel logo = new JLabel(iconoFinal);
        logo.setBounds(20, 25, 150, 150);
        panelSuperior.add(logo);

        // bienvenida
        JLabel bienvenida = new JLabel("Bienvenido al Comedor Estudiantil");
        bienvenida.setBounds(200, 40, 600, 100);
        bienvenida.setFont(new Font("Roboto Black", Font.BOLD, 30));
        bienvenida.setForeground(Color.WHITE);
        bienvenida.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(bienvenida);

        // Frase inspiradora
        JLabel frase = new JLabel("De la casa que vence las sombras");
        frase.setBounds(200, 100, 800, 50);
        frase.setFont(new Font("Roboto", Font.PLAIN, 22));
        frase.setForeground(Color.WHITE);
        frase.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(frase);

        // Cambia el layout del panel superior a BorderLayout
        panelSuperior.setLayout(new BorderLayout());

        // Panel para logo y textos (izquierda)
        JPanel panelIzquierda = new JPanel(null);
        panelIzquierda.setOpaque(false);
        panelIzquierda.setPreferredSize(new Dimension(900, 200));
        // Logo
        logo = new JLabel(iconoFinal);
        logo.setBounds(20, 25, 150, 150);
        panelIzquierda.add(logo);
        // Bienvenida
        bienvenida = new JLabel("Bienvenido al Comedor Estudiantil");
        bienvenida.setBounds(200, 40, 600, 100);
        bienvenida.setFont(new Font("Roboto Black", Font.BOLD, 30));
        bienvenida.setForeground(Color.WHITE);
        bienvenida.setHorizontalAlignment(SwingConstants.LEFT);
        panelIzquierda.add(bienvenida);
        // Frase
        frase = new JLabel("De la casa que vence las sombras");
        frase.setBounds(200, 100, 800, 50);
        frase.setFont(new Font("Roboto", Font.PLAIN, 22));
        frase.setForeground(Color.WHITE);
        frase.setHorizontalAlignment(SwingConstants.LEFT);
        panelIzquierda.add(frase);

        panelSuperior.add(panelIzquierda, BorderLayout.CENTER);

        // Panel para los botones (derecha)
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(new EmptyBorder(60, 0, 0, 50)); // 50px margen derecho

        controlerInicioUser cLU = controlerInicioUser.getInstance();

        JButton NameAdmin = new JButton(cLU.usuario);
        NameAdmin.setFont(new Font("Roboto", Font.BOLD, 18));
        NameAdmin.setBackground(new Color(21, 174, 92));
        NameAdmin.setForeground(Color.WHITE);
        NameAdmin.setBorderPainted(false);
        NameAdmin.setFocusPainted(false);
        NameAdmin.setMaximumSize(new Dimension(200, 40));
        NameAdmin.setPreferredSize(new Dimension(200, 40));
        NameAdmin.setMinimumSize(new Dimension(200, 40));

        JButton botonLogin = new JButton("VOLVER");
        botonLogin.setFont(new Font("Roboto", Font.BOLD, 18));
        botonLogin.setBackground(new Color(48, 43, 47));
        botonLogin.setForeground(Color.WHITE);
        botonLogin.setBorderPainted(false);
        botonLogin.setFocusPainted(false);
        botonLogin.setMaximumSize(new Dimension(200, 40));
        botonLogin.setPreferredSize(new Dimension(200, 40));
        botonLogin.setMinimumSize(new Dimension(200, 40));

        panelBotones.add(NameAdmin);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10))); // separación vertical
        panelBotones.add(botonLogin);


        panelSuperior.add(panelBotones, BorderLayout.EAST);

        // Agregar el panel superior al contenedor
        getContentPane().add(contenedorSuperior);

                // Panel para el subtítulo alineado a la izquierda
        JPanel panelSubtitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSubtitulo.setBackground(new Color(39, 39, 39));
        panelSubtitulo.setPreferredSize(new Dimension(1280, 50));

        JLabel subtitulo = new JLabel("Recargar Saldo");
        subtitulo.setFont(new Font("Roboto Black", Font.BOLD, 42));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo.add(subtitulo);

        // Agrega el panel del subtítulo debajo del panel superior
        getContentPane().add(panelSubtitulo);

        // Panel de Campos Para Recargar Saldo
        authPanel = new AuthPanel();
        JPanel panelCampos = new JPanel(new GridBagLayout());
        panelCampos.setBackground(new Color(39, 39, 39));
        GridBagConstraints gbcCampos = new GridBagConstraints();
        gbcCampos.gridx = 0;
        gbcCampos.gridy = 0;
        gbcCampos.insets = new Insets(10, 40, 5, 40);
        gbcCampos.anchor = GridBagConstraints.WEST;

        // Cedula
        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("Roboto", Font.BOLD, 22));
        lblCedula.setForeground(Color.WHITE);
        panelCampos.add(lblCedula, gbcCampos);

        gbcCampos.gridx = 1;
        JTextField txtCedula = new JTextField(12);
        txtCedula.setFont(new Font("Roboto", Font.PLAIN, 20));
        txtCedula.setBackground(new Color(96, 96, 96));
        txtCedula.setForeground(Color.WHITE);
        txtCedula.setPreferredSize(new Dimension(500, 30));
        panelCampos.add(txtCedula, gbcCampos);

        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        JLabel lblpasswrd = new JLabel("Contraseña");
        lblpasswrd.setFont(new Font("Roboto", Font.BOLD, 22));
        lblpasswrd.setForeground(Color.WHITE);
        panelCampos.add(lblpasswrd, gbcCampos);

        gbcCampos.gridx = 1;
        JPasswordField txtpaswrd = new JPasswordField(12);
        txtpaswrd.setFont(new Font("Roboto", Font.PLAIN, 20));
        txtpaswrd.setBackground(new Color(96, 96, 96));
        txtpaswrd.setForeground(Color.WHITE);
        txtpaswrd.setPreferredSize(new Dimension(500, 30));
        panelCampos.add(txtpaswrd, gbcCampos);


        // Monto
        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setFont(new Font("Roboto", Font.BOLD, 22));
        lblMonto.setForeground(Color.WHITE);
        panelCampos.add(lblMonto, gbcCampos);

        gbcCampos.gridx = 1;
        JTextField txtMonto = new JTextField(12);
        txtMonto.setFont(new Font("Roboto", Font.PLAIN, 20));
        txtMonto.setBackground(new Color(96, 96, 96));
        txtMonto.setForeground(Color.WHITE);
        txtMonto.setPreferredSize(new Dimension(500, 30));        
        panelCampos.add(txtMonto, gbcCampos);

        // Saldo actual (opcional, solo visual)
        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        gbcCampos.gridwidth = 2;
        JLabel lblSaldo = new JLabel("Saldo actual: " + cLU.saldo + " Bs");
        lblSaldo.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblSaldo.setForeground(Color.WHITE);
        panelCampos.add(lblSaldo, gbcCampos);

        // Botón de Recargar Saldo debajo del saldo actual
        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        gbcCampos.gridwidth = 2;
        gbcCampos.anchor = GridBagConstraints.CENTER;
        RoundedButton btnRecargarSaldo = new RoundedButton("Recargar Saldo");
        btnRecargarSaldo.setFont(new Font("Roboto", Font.BOLD, 22));
        btnRecargarSaldo.setBackground(new Color(21, 174, 92));
        btnRecargarSaldo.setForeground(Color.WHITE);
        btnRecargarSaldo.setPreferredSize(new Dimension(200, 50));
        panelCampos.add(btnRecargarSaldo, gbcCampos);

        // Agrega el panel de campos al frame
        getContentPane().add(panelCampos);

        botonLogin.addActionListener(e -> volver());
            
      
        btnRecargarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaIngresada = txtCedula.getText().trim();
                String passwrdIngresada = txtpaswrd.getText().trim();
                String montoIngresado = txtMonto.getText().trim();

                if (cedulaIngresada.isEmpty() || montoIngresado.isEmpty() || passwrdIngresada.isEmpty()) {
                    JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "Debe llenar todos los campos de información", "Campos obligatorios", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Aquí debes comparar con la cédula real del usuario. Por ejemplo:
                

                if (!cedulaIngresada.equals(cLU.cedula)) {
                    JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "La cédula no coincide con la del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!passwrdIngresada.equals(cLU.password)) {
                    JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    float monto = Float.parseFloat(montoIngresado);
                    if (monto <= 0) {
                        JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "El monto debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    cLU.saldo = cLU.saldo + monto;
                    lblSaldo.setText("Saldo actual: " + cLU.saldo + " Bs");
                    JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "Saldo recargado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    new InicioVisual().setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RecargarSaldoVisual.this, "Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });


    }

    private void volver() {

        new InicioVisualAdmin().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RecargarSaldoVisual().setVisible(true);
        });
    }

}