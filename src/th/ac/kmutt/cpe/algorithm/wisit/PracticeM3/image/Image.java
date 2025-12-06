package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.image;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private int height;
    private int width;
    private int[][] pixels;

    // Create image object by importing the .png file
    public Image(String filePath) {
        try {
            File file = new File(filePath);
            BufferedImage img = ImageIO.read(file);
            Raster raster = img.getRaster();

            this.height = img.getHeight();
            this.width = img.getWidth();

            this.pixels = new int[this.height][this.width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixels[y][x] = raster.getSample(x, y, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create an empty Image (given height and width)
    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        this.pixels = new int[height][width];
    }

    // Export the image object into .png file according to the file name.
    public void export(String fileName) {
        BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = img.getRaster();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                raster.setSample(x, y, 0, this.pixels[y][x]);
            }
        }

        try {
            // CHANGE the value into your lowercase name in LEB2
            String yourName = "wisit";
            ImageIO.write(img, "png", new File("src/th/ac/kmutt/cpe/algorithm/" + yourName + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getPixels() {
        return pixels;
    }

    public int getPixels(int y, int x) {
        return pixels[y][x];
    }

    public void setPixels(int y, int x, int val) {
        this.pixels[y][x] = val;
    }

    public void brighten(Image img, int intensity) {
        int h = img.getHeight();
        int w = img.getWidth();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (pixels[y][x] + intensity > 255) {
                    pixels[y][x] = 255;
                } else {
                    pixels[y][x] = img.pixels[y][x] + intensity;
                }
            }
        }
    }

    public void darken(Image img, int intensity) {
        int h = img.getHeight();
        int w = img.getWidth();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (pixels[y][x] - intensity < 0) {
                    pixels[y][x] = 0;
                } else {
                    pixels[y][x] = img.pixels[y][x] - intensity;
                }
            }
        }
    }
}