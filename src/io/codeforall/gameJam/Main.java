package io.codeforall.gameJam;

public class Main {

    public static void main(String[] args) {

        Background background = new Background(10, 10, Utilities.PREFIX+"board.png");
        background.drawBackground();

        Dado dado = new Dado(Utilities.PREFIX + "Dice1TOP.png");
        dado.drawDado();

    }


}
