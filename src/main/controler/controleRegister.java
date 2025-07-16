package main.controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class controleRegister{
    public controleRegister(){}

    public Boolean Validar(String data){
        Boolean Flag = false;
        try{
            File BaseDT = new File("output.txt");
            Scanner myReader = new Scanner(BaseDT);


            while (myReader.hasNextLine()){
                String data1 = myReader.nextLine();
                if (data1.equals(data)) {
                Flag = true;
                }
            }

            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Flag;
    }

    public void Registrar(String Cedula, String name,String email,String password){
        try{
            File BaseDT = new File("output.txt");
            FileWriter myWriter = new FileWriter(BaseDT, true);

            myWriter.write(Cedula + "\n" +name + "\n" + email + "\n"+ password + "\n" );

            myWriter.close();
        } catch  (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
