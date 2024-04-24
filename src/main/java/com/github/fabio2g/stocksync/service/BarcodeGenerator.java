package com.github.fabio2g.stocksync.service;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

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

    private static BufferedImage decodeBase64ToImage(String base64Image) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImage = ImageIO.read(bis);
            bis.close();

            return bufferedImage;
        } catch (IOException e) {
            System.out.println("Erro ao decodificar a imagem: " + e);
            return null;
        }
    }

    public static void generateImageBarcode(String fileName, String base64Image) {
        BufferedImage image = decodeBase64ToImage(base64Image);

        if (image != null) {
            String directoryPath = "C:\\Users\\Fabio\\Documents\\Github\\Java\\stock-sync\\src\\main\\resources\\barcode\\";
            String outputPath = directoryPath + fileName + ".png";

            if (fileName.isEmpty()) {
                String uniqueFileName = UUID.randomUUID().toString() + ".png";
                outputPath = directoryPath + uniqueFileName;
            }

            try {
                File outputFile = new File(outputPath);

                ImageIO.write(image, "png", outputFile);
            } catch (IOException e) {
                System.out.println("Erro ao salvar a imagem decodificada: " + e);
            }
        } else {
            System.out.println("Erro ao decodificar a imagem Base64.");
        }
    }
}
