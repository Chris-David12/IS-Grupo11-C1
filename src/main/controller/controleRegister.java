package main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class controleRegister {
    public controleRegister() {
    }

    Integer UserID = 1;

    public Boolean Validar(String data) {

        Boolean Flag = false;

        try {
            File BaseDT = new File("dataBase.txt");
            Scanner myReader = new Scanner(BaseDT);

            while (myReader.hasNextLine()) {

                String data1 = myReader.nextLine();
                try {
                    if (UserID.equals(Integer.parseInt(data1))) {
                        UserID += 1;
                    } else if (data1.equals(data)) {
                        Flag = true;
                    }
                } catch (NumberFormatException e) {

                    if (data1.equals(data)) {
                        Flag = true;
                    }
                }
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Flag;
    }

    public void RegistrarUser(String Cedula, String name, String email, String password) {
        try {
            File BaseDT = new File("dataBase.txt");
            FileWriter myWriter = new FileWriter(BaseDT, true);

            myWriter.write(UserID + "\n" + Cedula + "\n" + "Comensal" + "\n" + name + "\n" + email + "\n" + password
                    + "\n" + "0.00" + "\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void RegistrarAdmin(String Cedula, String name, String email, String password) {
        try {
            File BaseDT = new File("dataBase.txt");
            FileWriter myWriter = new FileWriter(BaseDT, true);

            myWriter.write(
                    UserID + "\n" + Cedula + "\n" + "Admin" + "\n" + name + "\n" + email + "\n" + password + "\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
