package com.gruntik.foodmatcher.forstart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FastGetCommonColor {

    public static void main(String[] args) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File("D://FoodMatcher/images/img.png"));

        bufferedImage = resizeImage(bufferedImage, 1, 1);

        Date date = new Date();
        String fileName = "img" + date.getMinutes() + "-" + date.getSeconds() + ".png";

        ImageIO.write(bufferedImage.getSubimage(0, 0, 1, 1), "png",
                new File("D://FoodMatcher/images/" + fileName));

        System.out.println(ImageColor.getPixelColor(bufferedImage, 0, 0));
    }

    static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }
}
