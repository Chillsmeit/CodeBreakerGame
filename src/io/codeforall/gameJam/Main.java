package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {

        Rectangle background1 = new Rectangle(10,10,1500,750);
        background1.setColor(new Color(47,130,108) );
        background1.fill();
        Background background = new Background(10, 10, Utilities.PREFIX+"board.png");
        background.drawBackground();
        Picture picture = new Picture(750,50,Utilities.PREFIX+"CreamyRectangle.png");
        picture.draw();
        Dado dado = new Dado(Utilities.PREFIX + "Dice1TOP.png");
        dado.drawDado();

    }


}
