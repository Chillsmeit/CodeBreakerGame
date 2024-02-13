package io.codeforall.gameJam;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Background background = new Background(10, 50, Utilities.PREFIX+"tabuleiro.jpg");
        background.drawBackground();

        Game game = new Game();
        game.init();

        //Player player = new Player(800, 800,Utilities.PREFIX +"pawn.png");
        //player.drawPlayer();

        //Dado dado = new Dado(Utilities.PREFIX + "dice_1.png");
        //dado.drawDado();

    }


}
