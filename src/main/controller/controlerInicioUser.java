package main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class controlerInicioUser {

    private static controlerInicioUser controler;

    public String usuario = "";
    public String cedula = "";
    public String correo = "";
    public String password = "";
    public String rol = "";
    public Float saldo = null;
    private static final String FILE_PATH = "Instancia.txt";


    private controlerInicioUser() {
        cargarDatosUsuario();
    }

    public static controlerInicioUser getInstance(){
        if(controler == null){
            controler = new controlerInicioUser();
        }
        
        return controler;
    }

    private void cargarDatosUsuario() {
        try {
            File BaseDT = new File(FILE_PATH);
            Scanner myReader = new Scanner(BaseDT);

            cedula = myReader.nextLine().trim();
            rol = myReader.nextLine().trim();
            usuario = myReader.nextLine().trim();
            correo = myReader.nextLine().trim();
            password = myReader.nextLine().trim();
            if (!rol.equals("Admin")) {
                saldo = Float.parseFloat(myReader.nextLine().trim());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading user data.");
            e.printStackTrace();
        }
    }

    public void actualizarBD() throws IOException{
        File archivo = new File("dataBase.txt");
        List<String> lineas = new ArrayList<>();

        Boolean Flag = false;

        // Leer todas las líneas
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                lineas.add(sc.nextLine());
            }
        }

        Integer aux = 0;
        // Buscar y modificar la línea que contiene un texto específico
        String textoABuscar = this.cedula;
        String textoNuevo = String.valueOf(this.saldo);
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).contains(textoABuscar)) {
                Flag = true;
            }

            if (Flag && (aux.equals(5))) {
                lineas.set(i, textoNuevo);
                break;
            }else if (Flag) {
                aux += 1;
            }
        }

        // Escribir todas las líneas de nuevo en el archivo
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                pw.println(linea);
            }
        }
    }

    // Método para limpiar el archivo al cerrar sesión
    public static void limpiarArchivoSesion() {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(""); // Escribe una cadena vacía
            writer.close();
            System.out.println("Datos de sesión eliminados correctamente.");

            if(!controler.rol.equals("Admin")){
            controler.actualizarBD();}

            controler = null;
        } catch (IOException e) {
            System.out.println("Error al limpiar los datos de sesión.");
            e.printStackTrace();
        }
    }

}