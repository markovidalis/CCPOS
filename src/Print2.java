
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marko
 */
public class Print2 {

    public static void main(String[] args) throws OutputException, IOException {

        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        //print some stuff
        printerService.printString("EPSON TM-T20II Receipt", "\n\n testing testing 1 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Barcode barcode = null;
        String barcodeNumber = "0129";
        Image bfi = null;
        try {
            barcodeNumber = "0397";
            barcode = BarcodeFactory.createCode128B(barcodeNumber);
            bfi = BarcodeImageHandler.getImage(barcode);
            File f = new File("C:\\development\\barcodejpeg.jpg");
            if(!f.exists()){
                f.createNewFile();
            }
            BarcodeImageHandler.saveJPEG(barcode, f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) bfi, "jpg", f);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            printerService.printImage("EPSON TM-T20II Receipt", ImageIO.read(f));

            baos.close();

        } catch (BarcodeException e) {
            // Error handling
        } catch (OutputException ex) {
            Logger.getLogger(PrinterService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrinterService.class.getName()).log(Level.SEVERE, null, ex);
        }

        // cut that paper!
        byte[] cutP = new byte[]{0x1d, 'V', 1};

        printerService.printBytes("EPSON TM-T20II Receipt", cutP);

    }
}
