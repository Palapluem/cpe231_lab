package th.ac.kmutt.cpe.algorithm.wisit.PracticeM3;

import th.ac.kmutt.cpe.algorithm.wisit.PracticeM3.image.Image;

public class ImageMain {
    public static void main(String[] args) {
        Image img = new Image(
                "D:\\Algorithm_Lab\\src\\th\\ac\\kmutt\\cpe\\algorithm\\wisit\\PracticeM3\\image\\meme.jpg");
        System.out.printf("Image Height : %d | Image Width : %d", img.getHeight(), img.getWidth());

        Image brighten = new Image(img.getHeight(), img.getWidth());
        Image darken = new Image(img.getHeight(), img.getWidth());

        brighten.brighten(img, 80);
        darken.darken(img, 100);

        brighten.export("meme_brighten.jpg");
        darken.export("meme_darken.jpg");

        System.out.println("\nDone!");
    }
}