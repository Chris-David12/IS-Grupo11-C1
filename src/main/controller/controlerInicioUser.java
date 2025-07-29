package main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class controlerInicioUser {
    private static final String FILE_PATH = "Instancia.txt";
    public String usuario = "";
    public String cedula = "";
    public String correo = "";
    public String password = "";
    public String rol = "";
    public Float saldo = null;

    public controlerInicioUser() {

        try {
            File BaseDT = new File(FILE_PATH);
            Scanner myReader = new Scanner(BaseDT);

            cedula = myReader.nextLine().trim();
            rol = myReader.nextLine().trim();
            usuario = myReader.nextLine().trim();
            correo = myReader.nextLine().trim();
            password = myReader.nextLine().trim();
            if (rol.equals("Comensal")) {
                saldo = Float.parseFloat(myReader.nextLine().trim());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void limpiarArchivoSesion() {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(""); // Escribe una cadena vacía
            writer.close();
            System.out.println("Datos de sesión eliminados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al limpiar los datos de sesión.");
            e.printStackTrace();
        }
    }
}