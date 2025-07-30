package main.controller;

import main.model.TarjetaMenu;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class controllerMenu {
    private static final String ARCHIVO_MENUS = "menuDataBase.txt";
    private int nextId = 1;

    public controllerMenu() {
        calcularNextId();
    }

    private void calcularNextId() {
        try {
            List<TarjetaMenu> menus = cargarMenus();
            this.nextId = menus.stream()
                    .mapToInt(TarjetaMenu::getId)
                    .max()
                    .orElse(0) + 1;
        } catch (IOException e) {
            this.nextId = 1;
        }
    }

    public TarjetaMenu crearNuevoMenu() {
        return new TarjetaMenu(
                nextId++,
                "Desayuno",
                LocalDate.now().toString(),
                "07:00-09:00",
                "",
                0,
                0.0,
                0.0);
    }

    public boolean validarMenu(TarjetaMenu menu) {
        return menu != null &&
                !menu.getTipo().isEmpty() &&
                !menu.getFecha().isEmpty() &&
                !menu.getHorario().isEmpty() &&
                menu.getCantidadUsuarios() > 0;
    }

    public void agregarMenu(List<TarjetaMenu> menus, TarjetaMenu nuevoMenu, JFrame parent) {
        if (!validarMenu(nuevoMenu)) {
            JOptionPane.showMessageDialog(parent,
                    "Datos del menú incompletos o inválidos",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        menus.add(nuevoMenu);
        guardarMenus(menus);

        JOptionPane.showMessageDialog(parent,
                "Menú agregado correctamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<TarjetaMenu> cargarMenus() throws IOException {
        List<TarjetaMenu> menus = new ArrayList<>();
        File file = new File(ARCHIVO_MENUS);

        if (!file.exists()) {
            crearArchivoInicial();
            return menus;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Saltar encabezado
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 7) {
                    menus.add(new TarjetaMenu(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            Integer.parseInt(parts[5]),
                            Double.parseDouble(parts[6]),
                            Double.parseDouble(parts[7])));
                }
            }
        }
        return menus;
    }

    public void guardarMenus(List<TarjetaMenu> menus) {
        try (PrintWriter writer = new PrintWriter(ARCHIVO_MENUS)) {
            writer.println("id|tipo|fecha|horario|descripcion|cantidadUsuarios|constante|variable");
            for (TarjetaMenu menu : menus) {
                writer.println(String.format("%d|%s|%s|%s|%s|%d|%.2f|%.2f",
                        menu.getId(),
                        menu.getTipo(),
                        menu.getFecha(),
                        menu.getHorario(),
                        menu.getDescripcion(),
                        menu.getCantidadUsuarios(),
                        menu.getConstante(),
                        menu.getVariable()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al guardar menús: " + e.getMessage());
        }
    }

    private void crearArchivoInicial() throws IOException {
        try (PrintWriter writer = new PrintWriter(ARCHIVO_MENUS)) {
            writer.println("id|tipo|fecha|horario|descripcion|cantidadUsuarios|constante|variable");
            writer.println("1|Desayuno|" + LocalDate.now() + "|07:00-09:00|Café, pan, fruta|50|100.0|50.0");
            writer.println("2|Almuerzo|" + LocalDate.now() + "|12:00-14:00|Sopa, pollo, arroz|80|120.0|60.0");
        }
    }
}