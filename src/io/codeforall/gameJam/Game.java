package io.codeforall.gameJam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private final ExecutorService executorService;
    private Player player;

    public Game () {
        executorService = Executors.newFixedThreadPool(1);
        player = new Player(825, 870, Utilities.PREFIX+"pawn.png", "ZUKA");
        init();
    }

    public void init() {
        player.drawPlayer();
    }

    public void movePlayer(int numSteps) {
        Runnable runnable;
        executorService.execute(() -> {
            for (int i = 0; i < numSteps; i++) {
                player.moveLeft();

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



}
