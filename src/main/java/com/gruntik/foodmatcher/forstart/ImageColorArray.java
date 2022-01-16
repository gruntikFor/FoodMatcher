package com.gruntik.foodmatcher.forstart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageColorArray {

    public static void main(String[] args) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File("D://FoodMatcher/images/img.png"));
//        Color color = ImageColor.getPixelColor(bufferedImage, 2, 0);
//        System.out.println(color);

        float[][][] array = new float[bufferedImage.getWidth()][bufferedImage.getHeight()][3];
        printTripleArray(array);

        getRGBArray(array, bufferedImage);
        System.out.println("after ----------------");
        printTripleArray(array);
    }

    public static void printTripleArray(float[][][] array) {
        for (int y = 0; y < array[0].length; y++) {
            System.out.print("y: " + y + " ");
            for (int x = 0; x < array.length; x++) {
                System.out.print(" " + x + ":[");
                for (int k = 0; k < array[x][y].length; k++) {
                    System.out.print(array[x][y][k] + " ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public static void getRGBArray(float[][][] array, BufferedImage bufferedImage) {
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                for (int k = 0; k < array[x][y].length; k++) {
                    Color color = ImageColor.getPixelColor(bufferedImage, x, y);

                    array[x][y][0] = color.getRed();
                    array[x][y][1] = color.getGreen();
                    array[x][y][2] = color.getBlue();
                }
            }
        }
    }

}
