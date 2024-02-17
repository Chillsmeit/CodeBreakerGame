package io.codeforall.gameJam;

public class Main {

    public static void main(String[] args) {

        Background background = new Background(10, 10, Utilities.PREFIX+"board.png");
        background.drawBackground();

        //Game game = new Game();

        Dado dado = new Dado(Utilities.PREFIX + "Dice1TOP.png");
        dado.drawDado();


        //Player player = new Player(800, 800,Utilities.PREFIX +"pawn.png");
        //player.drawPlayer();

        //Dado dado = new Dado(Utilities.PREFIX + "dice_1.png");
        //dado.drawDado();

    }


}
