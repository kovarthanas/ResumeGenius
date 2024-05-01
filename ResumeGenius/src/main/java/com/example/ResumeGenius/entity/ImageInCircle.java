package com.example.ResumeGenius.entity;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.geom.Ellipse2D;


public class ImageInCircle {
    Image img;
    public void cropImageIntoCircle(String imgFile) {
        try {
            img = ImageIO.read(new File(imgFile));
        } catch (IOException fne) {
            fne.printStackTrace();
        }
        int width = img.getWidth(null);
        int height = img.getHeight(null);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int circleDiameter = Math.min(width,height);
        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,circleDiameter,circleDiameter);
        g2.setClip(circle);
        g2.drawImage(img,0,0,null);
        try {
            ImageIO.write(bi, "PNG", new File("assets/" + imgFile.substring(0, imgFile.lastIndexOf(".")) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
