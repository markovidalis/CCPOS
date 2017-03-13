/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import net.sourceforge.barbecue.*;
import static net.sourceforge.barbecue.BarcodeImageHandler.getImage;
import net.sourceforge.barbecue.output.OutputException;

public class Print {

    /**
     *
     */
    public static void main(String[] args) throws OutputException, IOException {
        PrinterOptions p = new PrinterOptions();
        
         
         
       
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//            BarcodeImageHandler.writeJPEG(barcode, baos);
//            byte[] imageInByte = baos.toByteArray();
//            
//            
//            // p.addLineSeperator();
//            p.feed((byte) 3);
//            //  p.finit();
//            PrinterOptions.feedPrinterImage(baos);
//        }

       // BufferedImage img = BarcodeImageHandler.getImage(barcode);
        //Graphics2D g2d = img.createGraphics();
       // args.Graphics.drawImage(img);
        
     
            
      
    
        

        p.resetAll();
        p.initialize();
        p.feedBack((byte) 2);
        //p.color(0);
        p.chooseFont(4);
        p.alignCenter();
        p.setText("Check Cleaners");
        p.newLine();
        p.setText("Cnr George & Bradfield Dr. Fairmount");
        p.newLine();
        p.setText("011 640 3596/082 609 2786");
        p.newLine();
        p.setText("VAT NUMBER: 4200261230");
        p.addLineSeperator();
        p.newLine();

        p.alignLeft();
        p.setText("POD No \t: 2001 \tTable \t: E511");
        p.newLine();

        p.setText("Res Date \t: " + "01/01/1801 22:59");

        p.newLine();
        p.setText("Session \t: Evening Session");
        p.newLine();
        p.setText("Staff \t: Bum Dale");
        p.newLine();
        p.addLineSeperator();
        p.newLine();
        p.alignCenter();
        p.setText(" - Some Items - ");
        p.newLine();
        p.alignLeft();
        p.addLineSeperator();

        p.newLine();
p.feed((byte) 3);
        p.setText("No \tItem\t\tUnit\tQty");
        p.newLine();
        p.addLineSeperator();
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");
        p.setText("1" + "\t" + "Aliens Everywhere" + "\t" + "Rats" + "\t" + "500");

        p.addLineSeperator();
        p.feed((byte) 3);
        p.finit();

        PrinterOptions.feedPrinter(p.finalCommandSet().getBytes());
     
    }

}
