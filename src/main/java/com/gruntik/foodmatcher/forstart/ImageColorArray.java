package com.gruntik.foodmatcher.forstart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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

        BufferedImage bufferedImage = ImageIO.read(new File("D://FoodMatcher/images/img.png"));
//        Color color = ImageColor.getPixelColor(bufferedImage, 2, 0);
//        System.out.println(color);

        float[][][] array = new float[bufferedImage.getWidth()][bufferedImage.getHeight()][3];

        array = getRGBArray(array, bufferedImage);
//        printTripleArray(array);

        ArrayList<String> stringArrayList = tripleArrayToStringArrayList(array);

        System.out.println(stringArrayList.size());
        System.out.println(stringArrayList);

        Map<String, Integer> mapWord = FrequencyWord.getMostFrequencyWord(stringArrayList);
        mapWord = FrequencyWord.sortMap(mapWord);

        System.out.println(mapWord);
        System.out.println("Most frequency color is: " + FrequencyWord.getFirstColorFromMap(mapWord));

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
