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

public class CostosVisual extends JFrame {
    private AuthPanel authPanel;

    // Declara las variables como atributos de la clase
    private double valorConstante = 100.0;
    private double valorVariable = 200.0;

    public CostosVisual() {
        setTitle("Inicio");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        controlerInicioUser cLU = new controlerInicioUser();

        JButton NameAdmin = new JButton(cLU.usuario);
        NameAdmin.setFont(new Font("Roboto", Font.BOLD, 18));
        NameAdmin.setBackground(new Color(21, 174, 92));
        NameAdmin.setForeground(Color.WHITE);
        NameAdmin.setBorderPainted(false);
        NameAdmin.setFocusPainted(false);
        NameAdmin.setMaximumSize(new Dimension(200, 40));
        NameAdmin.setPreferredSize(new Dimension(200, 40));
        NameAdmin.setMinimumSize(new Dimension(200, 40));

        JButton botonLogin = new JButton("CERRAR SESIÓN");
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

        JLabel subtitulo = new JLabel("Costos generales del comedor");
        subtitulo.setFont(new Font("Roboto Black", Font.BOLD, 42));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo.add(subtitulo);

        // Agrega el panel del subtítulo debajo del panel superior
        getContentPane().add(panelSubtitulo);

        // Panel de costos personalizados
        JPanel panelCostos = new JPanel(new GridBagLayout());
        panelCostos.setBackground(new Color(39, 39, 39));
        GridBagConstraints gbcCostos = new GridBagConstraints();
        gbcCostos.gridx = 0;
        gbcCostos.gridy = 0;
        gbcCostos.insets = new Insets(10, 40, 5, 40);
        gbcCostos.anchor = GridBagConstraints.WEST;

        // Constantes
        JLabel lblConstante = new JLabel("CONSTANTES:");
        lblConstante.setFont(new Font("Roboto", Font.BOLD, 22));
        lblConstante.setForeground(Color.WHITE);
        panelCostos.add(lblConstante, gbcCostos);

        gbcCostos.gridy++;
        JLabel valorConstanteLabel = new JLabel(valorConstante + " Bs");
        valorConstanteLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        valorConstanteLabel.setForeground(Color.WHITE);
        panelCostos.add(valorConstanteLabel, gbcCostos);

        JButton btnCambiarConstante = new JButton("Cambiar");
        btnCambiarConstante.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnCambiarConstante.setBackground(new Color(21, 174, 92));
        btnCambiarConstante.setForeground(Color.WHITE);
        gbcCostos.gridx = 1;
        panelCostos.add(btnCambiarConstante, gbcCostos);

        // Variables
        gbcCostos.gridx = 0;
        gbcCostos.gridy++;
        JLabel lblVariable = new JLabel("VARIABLES:");
        lblVariable.setFont(new Font("Roboto", Font.BOLD, 22));
        lblVariable.setForeground(Color.WHITE);
        panelCostos.add(lblVariable, gbcCostos);

        gbcCostos.gridy++;
        JLabel valorVariableLabel = new JLabel(valorVariable + " Bs");
        valorVariableLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        valorVariableLabel.setForeground(Color.WHITE);
        panelCostos.add(valorVariableLabel, gbcCostos);

        JButton btnCambiarVariable = new JButton("Cambiar");
        btnCambiarVariable.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnCambiarVariable.setBackground(new Color(21, 174, 92));
        btnCambiarVariable.setForeground(Color.WHITE);
        gbcCostos.gridx = 1;
        panelCostos.add(btnCambiarVariable, gbcCostos);

        // CCB
        gbcCostos.gridx = 0;
        gbcCostos.gridy++;
        JLabel lblCCB = new JLabel("CCB:");
        lblCCB.setFont(new Font("Roboto", Font.BOLD, 22));
        lblCCB.setForeground(Color.WHITE);
        panelCostos.add(lblCCB, gbcCostos);

        gbcCostos.gridy++;
        JLabel valorCCBLabel = new JLabel((valorConstante + valorVariable) + " Bs");
        valorCCBLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        valorCCBLabel.setForeground(Color.WHITE);
        panelCostos.add(valorCCBLabel, gbcCostos);

        // Agrega el panel de costos al frame
        getContentPane().add(panelCostos);

        // Listeners para los botones
        btnCambiarConstante.addActionListener(e -> {
            String nuevoValor = JOptionPane.showInputDialog(this, "Nuevo valor para Constantes:", valorConstante);
            if (nuevoValor != null && !nuevoValor.isEmpty()) {
                try {
                    valorConstante = Double.parseDouble(nuevoValor);
                    valorConstanteLabel.setText(valorConstante + " Bs");
                    valorCCBLabel.setText((valorConstante + valorVariable) + " Bs");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
                }
            }
        });
        btnCambiarVariable.addActionListener(e -> {
            String nuevoValor = JOptionPane.showInputDialog(this, "Nuevo valor para Variables:", valorVariable);
            if (nuevoValor != null && !nuevoValor.isEmpty()) {
                try {
                    valorVariable = Double.parseDouble(nuevoValor);
                    valorVariableLabel.setText(valorVariable + " Bs");
                    valorCCBLabel.setText((valorConstante + valorVariable) + " Bs");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CostosVisual().setVisible(true);
        });
    }

}