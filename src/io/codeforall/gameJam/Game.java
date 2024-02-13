package io.codeforall.gameJam;

public class Game {

    private Dado dado;
    private Player player;

    public Game () {
        dado = new Dado(Utilities.PREFIX+"dice_1.png");
        player = new Player(800, 800, Utilities.PREFIX+"pawn.png");
    }

    public void init() {
        dado.drawDado();
        player.drawPlayer();
    }



}
