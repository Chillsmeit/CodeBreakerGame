package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture background;

    public Background(String pathToImage) {
        background = new Picture(0, 0, pathToImage);
    }

    public void drawBackground() {
        background.draw();
    }

}
