package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Picture player;

    public Player(int col, int row,String pathToImage) {
        player = new Picture(col, row, pathToImage);
    }
    public void drawPlayer(){
        player.draw();
    }

    public void moveRight() {
        player.translate(10, 0);
    }

    public void moveLeft() {
        player.translate(-10, 0);
    }

    public void moveUp() {
        player.translate(0,10);
    }

    public void moveDown() {
        player.translate(0,10);
    }

    public void movePlayer(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            moveLeft();
            drawPlayer();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
