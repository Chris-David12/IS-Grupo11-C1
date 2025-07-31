import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.List;
import javax.swing.border.EmptyBorder;

import main.model.TarjetaMenu;
import main.model.MenuCardAdmin;
import main.controller.controlerInicioUser;
import main.model.AuthPanel;
import main.model.RoundedButton;


public class EscaneoFacial extends JFrame {
    private AuthPanel authPanel;
    private double valorVariable = 200.0;
    private TarjetaMenu menu;

    public EscaneoFacial(TarjetaMenu tmenu) {
        this.menu= tmenu;
        
        setTitle("Escaneo Facial - Comedor Estudiantil");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(39, 39, 39));

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setPreferredSize(new Dimension(1280, 200));
        panelSuperior.setBackground(new Color(21, 174, 92));
        panelSuperior.setLayout(null);

        // Panel contenedor con margen para el panel superior
        JPanel contenedorSuperior = new JPanel(new BorderLayout());
        contenedorSuperior.setBackground(new Color(39, 39, 39));
        contenedorSuperior.setBorder(new EmptyBorder(10, 15, 10, 15));
        contenedorSuperior.setPreferredSize(new Dimension(1280, 220));

        contenedorSuperior.add(panelSuperior, BorderLayout.CENTER);

        // Logo posición izquierda panel superior
        ImageIcon iconoOriginal = new ImageIcon("../assets/logo.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
        JLabel logo = new JLabel(iconoFinal);
        logo.setBounds(20, 25, 150, 150);
        panelSuperior.add(logo);

        // Bienvenida
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
        panelBotones.setBorder(new EmptyBorder(60, 0, 0, 50));

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
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBotones.add(botonLogin);

        botonLogin.addActionListener(e -> volver());

        panelSuperior.add(panelBotones, BorderLayout.EAST);

        // Agregar el panel superior al contenedor
        getContentPane().add(contenedorSuperior);

        // Panel para el subtítulo alineado a la izquierda
        JPanel panelSubtitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSubtitulo.setBackground(new Color(39, 39, 39));
        panelSubtitulo.setPreferredSize(new Dimension(1280, 50));

        JLabel subtitulo = new JLabel("Escaneo Facial");
        subtitulo.setFont(new Font("Roboto Black", Font.BOLD, 42));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setBorder(new EmptyBorder(0, 50, 0, 0));
        panelSubtitulo.add(subtitulo);

        getContentPane().add(panelSubtitulo);

        // Panel de Campos
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

// Apartado para cargar imagen
        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        gbcCampos.gridwidth = 2;
        gbcCampos.insets = new Insets(10, 40, 10, 40);

        JLabel lblImagen = new JLabel("Arrastra una imagen aquí o haz clic en 'Cargar Imagen'");
        lblImagen.setFont(new Font("Arial", Font.PLAIN, 18));
        lblImagen.setForeground(Color.WHITE);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setOpaque(true);
        lblImagen.setBackground(new Color(60, 60, 60));
        lblImagen.setPreferredSize(new Dimension(400, 200));
        lblImagen.setBorder(BorderFactory.createDashedBorder(Color.GRAY));
        panelCampos.add(lblImagen, gbcCampos);



        // Habilitar drag & drop
        lblImagen.setTransferHandler(new TransferHandler() {
            @Override
            public boolean canImport(TransferSupport support) {
                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }
            @Override
            public boolean importData(TransferSupport support) {
                try {
                    List<File> files = (List<File>) support.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    if (!files.isEmpty()) {
                        ImageIcon icon = new ImageIcon(files.get(0).getAbsolutePath());
                        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        lblImagen.setIcon(new ImageIcon(img));
                        lblImagen.setText("");
                        return true;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return false;
            }
        });

            // Botón para cargar imagen manualmente
        gbcCampos.gridy++;
        gbcCampos.insets = new Insets(0, 40, 10, 40);
        JButton btnCargarImagen = new JButton("Cargar Imagen");
        btnCargarImagen.setFont(new Font("Arial", Font.BOLD, 18));
        btnCargarImagen.setBackground(new Color(21, 174, 92));
        btnCargarImagen.setForeground(Color.WHITE);
        btnCargarImagen.setPreferredSize(new Dimension(200, 40));
        panelCampos.add(btnCargarImagen, gbcCampos);

        btnCargarImagen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(panelCampos);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
                lblImagen.setText("");
            }
        });

        // Botón para escaneo facial
        gbcCampos.gridx = 0;
        gbcCampos.gridy++;
        gbcCampos.gridwidth = 2;
        gbcCampos.anchor = GridBagConstraints.CENTER;
        RoundedButton btnRecargarSaldo = new RoundedButton("Escanear");
        btnRecargarSaldo.setFont(new Font("Roboto", Font.BOLD, 22));
        btnRecargarSaldo.setBackground(new Color(21, 174, 92));
        btnRecargarSaldo.setForeground(Color.WHITE);
        btnRecargarSaldo.setPreferredSize(new Dimension(200, 50));
        panelCampos.add(btnRecargarSaldo, gbcCampos);

        panelCampos.setPreferredSize(new Dimension(800, 400)); // Ajusta el tamaño según tu preferencia
        panelCampos.setMaximumSize(new Dimension(900, 500));   // Opcional, para BoxLayout

        // Agrega el panel de campos al frame
        JScrollPane scroll = new JScrollPane(panelCampos);
        scroll.setBorder(null);
        getContentPane().add(scroll);
    }

    private void volver() {

        new InicioVisualAdmin().setVisible(true);
        dispose();
    }

}