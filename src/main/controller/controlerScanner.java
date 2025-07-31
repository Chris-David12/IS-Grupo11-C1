package main.controller;


import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.model.objectUser;

public class controlerScanner {
    
    public BufferedImage compareImg = null;
    public objectUser usuario = null;

    public controlerScanner(){
    }

    public boolean compareImages(String path1, BufferedImage img2, int tolerance) {
    try {
        String path = path1 + ".jpg";
        BufferedImage img1 = ImageIO.read(new File(path));
        
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }
        
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                int rgb1 = img1.getRGB(x, y);
                int rgb2 = img2.getRGB(x, y);
                
                // Extraer componentes con máscara de bits
                int r1 = (rgb1 >> 16) & 0xFF;
                int g1 = (rgb1 >> 8) & 0xFF;
                int b1 = rgb1 & 0xFF;
                
                int r2 = (rgb2 >> 16) & 0xFF;
                int g2 = (rgb2 >> 8) & 0xFF;
                int b2 = rgb2 & 0xFF;
                
                // Comparar con tolerancia
                if (Math.abs(r1 - r2) > tolerance || 
                    Math.abs(g1 - g2) > tolerance || 
                    Math.abs(b1 - b2) > tolerance) {
                    return false;
                }
            }
        }
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }

    public void Buscar(String User) {
        Integer UserID = 1;
        try {
            File BaseDT = new File("dataBase.txt");
            Scanner myReader = new Scanner(BaseDT);
            String data1 = myReader.nextLine();

            while (myReader.hasNextLine()) {

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
                    
                    CrearInstancia(UserID,"dataBase.txt");
                    
                    break;
                }
                
                data1 = myReader.nextLine();

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void CrearInstancia(Integer UserID, String BaseDT) {
        try {
            File scannerFile = new File(BaseDT);
            Scanner mScanner = new Scanner(scannerFile);
            File Instancia = new File("Instancia2.txt");
            FileWriter myWriter = new FileWriter(Instancia);
            String Data = "";
            String data1 = "";

            while (mScanner.hasNextLine()) {
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
            this.usuario= new objectUser();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
