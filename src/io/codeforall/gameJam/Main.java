package io.codeforall.gameJam;

public class Main {

    public static void main(String[] args) {

        Background background = new Background(10, 50, Utilities.PREFIX+"rsz_2gridwip_2.png");
        background.drawBackground();

        //Game game = new Game();

        Dado dado = new Dado(Utilities.PREFIX + "dice_1.png");
        dado.drawDado();


        //Player player = new Player(800, 800,Utilities.PREFIX +"pawn.png");
        //player.drawPlayer();

        //Dado dado = new Dado(Utilities.PREFIX + "dice_1.png");
        //dado.drawDado();

    }


}
