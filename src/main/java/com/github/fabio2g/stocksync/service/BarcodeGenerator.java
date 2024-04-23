package com.github.fabio2g.stocksync.service;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class BarcodeGenerator {

    public static String generateBarcode(String input) {
        try {
            Barcode barcode = BarcodeFactory.createCode128(input);

            barcode.setBarWidth(2);
            barcode.setResolution(300);
            BufferedImage barcodeImage = BarcodeImageHandler.getImage(barcode);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(barcodeImage, "png", baos);
            baos.flush();

            byte[] imageBytes = baos.toByteArray();
            baos.close();

            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            return base64Image;

        } catch (OutputException | IOException | BarcodeException e) {
            System.out.println("Erro ao gerar o código de barras: " + e);
            return null;
        }
    }
}
