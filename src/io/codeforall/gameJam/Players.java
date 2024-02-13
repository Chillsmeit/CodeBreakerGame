package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Players {
    private Picture player;

    public Players(Picture player) {
        this.player = player;
    }
    public void draw(){
        player.draw();
    }

    public void moveRight() {
        player.translate(5, 0);
    }

    public void moveLeft() {
        player.translate(-5, 0);
    }

    public void moveUp() {
        player.translate(0,-5);
    }

    public void moveDown() {
        player.translate(0,5);
    }
}
