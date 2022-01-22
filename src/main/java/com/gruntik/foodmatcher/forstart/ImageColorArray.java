package com.gruntik.foodmatcher.forstart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 1.Read bufferedImage;
 * 2.Create triple array
 * 3.Get RBG Array from color array
 * 4.Array to one-dimensional array
 * 5.Get most frequency color map
 * 6.Sort color
 * 7.Get most frequency color
 */
public class ImageColorArray {

    public static void main(String[] args) throws IOException {

        long startProgram0 = System.currentTimeMillis();

        BufferedImage bufferedImage = ImageIO.read(new File("D://FoodMatcher/images/img.png"));

        Image image = bufferedImage.getScaledInstance(10, 10, Image.SCALE_SMOOTH);

        Color color = getSpecificColor(image, 0, 0);

        System.out.println(color);

        float[][][] array = new float[bufferedImage.getWidth()][bufferedImage.getHeight()][3];

        long startProgram1 = System.currentTimeMillis();
        array = getRGBArray(array, bufferedImage);
        long endProgram1 = System.currentTimeMillis();
        System.out.println("getRGBArray: " + (endProgram1 - startProgram1) / 1000);

        ArrayList<String> stringArrayList = tripleArrayToStringArrayList(array);

        Map<String, Integer> mapWord = FrequencyWord.getMostFrequencyWord(stringArrayList);
        mapWord = FrequencyWord.sortMap(mapWord);

        System.out.println("Most frequency color is: " + FrequencyWord.getFirstColorFromMap(mapWord));

        long endProgram0 = System.currentTimeMillis();
        System.out.println("time perform: " + (endProgram0 - startProgram0) / 1000.0);

    }

    public static Color getSpecificColor(Image image, int x, int y) {
        if (image instanceof BufferedImage) {
            return new Color(((BufferedImage) image).getRGB(x, y));
        }
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int[] pixels = new int[width * height];
        PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
        try {
            grabber.grabPixels();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int c = pixels[x * width + y];
        int red = (c & 0x00ff0000) >> 16;
        int green = (c & 0x0000ff00) >> 8;
        int blue = c & 0x000000ff;
        return new Color(red, green, blue);
    }

    public static ArrayList<String> tripleArrayToStringArrayList(float[][][] array) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                stringArrayList.add(Arrays.toString(array[x][y]));
            }
        }
        return stringArrayList;
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

    public static float[][][] getRGBArray(float[][][] arrayOriginal, BufferedImage bufferedImage) {
        float[][][] array = new float[arrayOriginal.length][arrayOriginal[0].length][3];
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

        return array;
    }

}
