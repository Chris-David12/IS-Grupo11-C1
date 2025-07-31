package main.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class objectUser {

    public String usuario = "";
    public String cedula = "";
    public String correo = "";
    public String password = "";
    public String rol = "";
    public Float saldo = null;

    public objectUser(){
        try {
            File BaseDT = new File("Instancia2.txt");
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

    public Boolean saldoSuficiente(float monto){
        Boolean verificar = null;
        if(this.saldo <= monto){
            verificar= false;
            return verificar;
        }else{
            verificar = true;
            return verificar;
        }
    }

    public void descontarSaldo(float monto){
        if(this.rol == "Estudiante"){
            monto = monto * 0.25f;
        }else if(this.rol == "Profesor"){
            monto = monto * 0.8f;
        }else{
            monto = monto * 1.05f;
        }

        this.saldo = this.saldo - monto;
        this.saldo = Math.round(this.saldo * 100) / 100.0f;

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
}
