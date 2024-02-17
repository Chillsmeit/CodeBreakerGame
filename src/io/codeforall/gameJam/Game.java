package io.codeforall.gameJam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private final ExecutorService executorService;
    private Player player;

    public Game () {
        executorService = Executors.newFixedThreadPool(1);
        player = new Player(635, 620, Utilities.PREFIX+"piece-golden (2).png", "ZUKA");
        init();
    }

    public void init() {
        player.drawPlayer();
        player.yourTurn();
    }

    public void movePlayer(int numSteps) {
        if (player.yourTurn()) {
            Runnable runnable;
            executorService.execute(() -> {
                for (int i = 0; i < numSteps; i++) {
                    player.movePlayer();
                    player.setMoveCounter();
                }
            });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                player.isTurn();
            }
        }



