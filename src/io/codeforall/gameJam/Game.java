package io.codeforall.gameJam;

public class Game {

    private Player player;

    public Game () {
        player = new Player(800, 800, Utilities.PREFIX+"pawn.png");
        init();
    }

    public void init() {
        player.drawPlayer();
    }

    public void movePlayer(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            player.moveLeft();

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.removePlayer();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.refreshImage();
        }
    }



}
