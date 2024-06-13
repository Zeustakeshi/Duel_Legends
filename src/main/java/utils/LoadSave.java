package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class LoadSave {

    public static BufferedImage loadImage(String path) {

        path = path.startsWith("/") ? path : "/" + path;

        InputStream inputStream = LoadSave.class.getResourceAsStream(path);

        BufferedImage img = null;
        try {
            if (inputStream != null) {
                img = ImageIO.read(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
}
