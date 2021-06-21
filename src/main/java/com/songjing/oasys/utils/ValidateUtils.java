package com.songjing.oasys.utils;

import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/4/26 14:52
 */
@UtilityClass
public class ValidateUtils {

    /**
     * 验证码字符集
     */
    private static final char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    /**
     * 字符数量
     */
    private static final int SIZE = 4;

    /**
     * 干扰线数量
     */
    private static final int LINES = 10;

    /**
     * 宽度
     */
    private static final int WIDTH = 90;

    /**
     * 高度
     */
    private static final int HEIGHT = 30;
    /**
     * 字体大小
     */
    private static final int FONT_SIZE = 25;

    /**
     * 生成随机验证码及图片 Object[0]：验证码字符串； Object[1]：验证码图片。
     */
    public static Object[] createImage() {
        StringBuffer sb = new StringBuffer();
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 2.获取图片画笔
        Graphics graphic = image.getGraphics();
        // 3.设置画笔颜色
        graphic.setColor(Color.LIGHT_GRAY);
        // 4.绘制矩形背景
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        // 5.画随机字符
        Random ran = new Random();
        for (int i = 0; i < SIZE; i++) {
            // 取随机字符索引
            int n = ran.nextInt(chars.length);
            // 设置随机颜色
			/*graphic.setColor(getRandomColor(101, 111, 121));*/
            graphic.setColor(getRandomColor(150, 150, 150));
            // 设置字体大小
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            // 画字符
            graphic.drawString(chars[n] + "", i * WIDTH / SIZE, HEIGHT * 2 / 3);
            // 记录字符
            sb.append(chars[n]);
        }
        // 6.画干扰线
        for (int i = 0; i < LINES; i++) {
            // 设置随机颜色
            graphic.setColor(getRandomColor(255, 255, 255));
            // 随机画线
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }

        /**
         * //扭曲
         shearX(graphic, WIDTH, HEIGHT, Color.LIGHT_GRAY);
         shearY(graphic, WIDTH, HEIGHT, Color.LIGHT_GRAY);
         */

        // 7.返回验证码和图片

        return new Object[]{sb.toString(), image};
    }


    /**
     * 随机取色
     */
    public static Color getRandomColor(int r, int g, int b) {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(r), ran.nextInt(g), ran.nextInt(b));
        return color;
    }

    /**
     * fc:110 bc:133
     *
     * @param fc
     * @param bc
     * @return
     */
    public static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        Random random = new Random();
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = 2;

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1) * Math.sin((double) i / (double) period + (2.2831853071795862D * (double) phase) / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = random.nextInt(2);
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (2.2831853071795862D * (double) phase) / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }

    }

}
