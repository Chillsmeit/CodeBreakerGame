package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Picture player;
    private String name;
    private boolean turn;

    public Player(int col, int row,String pathToImage, String name) {
        player = new Picture(col, row, pathToImage);
        this.name = name;
        Text text = new Text(1250, 100, name);
        text.setColor(Color.BLACK);
        text.grow(50, 50);
        text.draw();
    }
    public void drawPlayer(){
        player.draw();
    }

    public void moveRight() {
        player.translate(10, 0);
    }

    public void moveLeft() {
        player.translate(-70, 0);
    }

    public void moveUp() {
        player.translate(0,10);
    }

    public void moveDown() {
        player.translate(0,10);
    }

    public void refreshImage() {
        player.load(Utilities.PREFIX + "pawn.png");
    }

    public boolean yourTurn() {
        return turn = true;
    }

    public void turnOf() {
        turn = false;
    }

    public String getName() {
        return name;
    }

}
