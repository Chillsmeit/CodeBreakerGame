package io.codeforall.gameJam;

import io.codeforall.gameJam.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture background;

    public Background(int cols, int rows, String pathToImage) {
        background = new Picture(rows, cols, pathToImage);
    }

    public void drawBackground() {
        background.draw();
    }


}
