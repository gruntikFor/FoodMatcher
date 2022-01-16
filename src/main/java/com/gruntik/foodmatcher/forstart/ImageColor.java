package com.gruntik.foodmatcher.forstart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageColor {

    public static void main(String[] args) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File("D://FoodMatcher/images/img.png"));
        Color color = getPixelColor(bufferedImage, 2, 0);
        System.out.println(color);

        System.out.println("width: " + bufferedImage.getWidth() + " height: " + bufferedImage.getHeight());

        float[] rgbColor;

        float[] hsbvals = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsbvals);
        System.out.println("hsb color:" + Arrays.toString(hsbvals));

        getHSBValuesWithPercent(hsbvals);
        System.out.println("percents: " + Arrays.toString(hsbvals));

        decreaseSaturation(hsbvals);

        getHSBValuesWithDecimal(hsbvals);
        System.out.println("decimal: " + Arrays.toString(hsbvals));

        int rgbColorInt = Color.HSBtoRGB(hsbvals[0], hsbvals[1], hsbvals[2]);
        rgbColor = convertRGBIntToArray(rgbColorInt);

        System.out.println(Arrays.toString(rgbColor));
    }

    private static void decreaseSaturation(float[] hsbvals) {
        hsbvals[1] = 15f;
    }

    //1% 3.63
    private static void getHSBValuesWithPercent(float[] hsbvals) {
        hsbvals[0] = hsbvals[0] * 100 * 3.6f;
        hsbvals[1] = hsbvals[1] * 100;
        hsbvals[2] = hsbvals[2] * 100;
    }

    private static void getHSBValuesWithDecimal(float[] hsbvals) {
        hsbvals[0] = hsbvals[0] / 100 / 3.6f;
        hsbvals[1] = hsbvals[1] / 100;
        hsbvals[2] = hsbvals[2] / 100;
    }

    public static Color getPixelColor(BufferedImage bi, int x, int y) {
        Object colorData = bi.getRaster().getDataElements(x, y, null);//данные о пикселе
        int argb = bi.getColorModel().getRGB(colorData);//преобразование данных в цветовое значение
        return new Color(argb, true);
    }

    //convert HSBtoRGB to rgb array
    public static float[] convertRGBIntToArray(int rbgInt) {
        float[] rgbColor = new float[3];
        rgbColor[0] = (rbgInt >> 16) & 0xFF;
        rgbColor[1] = (rbgInt >> 8) & 0xFF;
        rgbColor[2] = rbgInt & 0xFF;
        return rgbColor;
    }

}
