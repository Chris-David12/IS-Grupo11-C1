package main.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class controlerLogin{
    public controlerLogin(){}

    

    Boolean Validar(String User, String password){
        Boolean Flag = false;
        Integer UserID = 1;
        try{
            File BaseDT = new File("output.txt");
            Scanner myReader = new Scanner(BaseDT);
            String data1 = myReader.nextLine();

            
            while (myReader.hasNextLine()){

                Integer auxInt = null;
                try {
                    auxInt = Integer.parseInt(data1);
                } catch (NumberFormatException e) {
                    auxInt = null;
                }
                if (auxInt != null && auxInt == UserID + 1) {
                    UserID = UserID + 1;
                }

                if (data1.equals(User)) {
                    data1  = myReader.nextLine();
                    if (data1.equals(password)) {
                       CrearInstancia(UserID, BaseDT);
                        Flag = true;
                        break; 
                    }else{
                        break;
                    }
                }
                data1 = myReader.nextLine();

            }

            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Flag;
    }

    void CrearInstancia(Integer UserID, File BaseDT){
        try{
            
            Scanner mScanner = new Scanner(BaseDT);
            File Instancia = new File("Instancia.txt");
            FileWriter myWriter = new FileWriter(Instancia);
            String Data = "";
            String data1 = "";

            while (mScanner.hasNextLine()){
                data1 = mScanner.nextLine();
                Integer auxInt = null;
                try {
                    auxInt = Integer.parseInt(data1);
                } catch (NumberFormatException e) {
                    auxInt = null;
                }

                if (auxInt != null && auxInt == UserID) {
                    while (mScanner.hasNextLine()) {
                        data1 = mScanner.nextLine();
                        try {
                            auxInt = Integer.parseInt(data1);
                        } catch (NumberFormatException e) {
                            auxInt = null;
                        }
                        if (auxInt != null && auxInt == UserID + 1) {
                            break;
                        }
                        Data += data1 + "\n";
                    }
                    break;
                }
            }

            myWriter.write(Data + "\n");
            mScanner.close();
            myWriter.close();
        } catch  (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
