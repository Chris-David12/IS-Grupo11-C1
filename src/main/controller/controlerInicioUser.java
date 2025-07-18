package main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class controlerInicioUser {
    public String usuario = "";
    public String cedula = "";
    public String correo = "";
    public String password = "";
    public String rol = "";
    public Float saldo = null;

    public controlerInicioUser(){

        try{
            File BaseDT = new File("Instancia.txt");
            Scanner myReader = new Scanner(BaseDT);

            cedula = myReader.nextLine().trim();
            rol = myReader.nextLine().trim();
            usuario = myReader.nextLine().trim();
            correo = myReader.nextLine().trim();
            password = myReader.nextLine().trim();
            if (rol.equals("Comensal")){
                saldo = Float.parseFloat(myReader.nextLine().trim());
            }

            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
