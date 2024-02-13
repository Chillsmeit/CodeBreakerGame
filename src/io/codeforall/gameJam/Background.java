package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture background;

    public Background(int cols, int rows, String pathToImage) {
        background = new Picture(cols, rows, pathToImage);
    }

    public void drawBackground() {
        background.draw();
    }


}
