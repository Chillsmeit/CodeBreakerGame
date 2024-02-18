package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game implements MouseHandler {
    private final ExecutorService executorService;

    private Player player;

    private Player player1;

    private Player player2;

    private Player player3;
    private Picture addPlayers;
    private int playerCount = 1;

    private int whoIsPlaying = 1;

    private boolean hasStarted = false;

    public Game() {
        executorService = Executors.newFixedThreadPool(2);
        player = new Player(635, 620, Utilities.PREFIX + "player.png", "ZUKA");
        init();
        addPlayers = new Picture(650,635,Utilities.PREFIX+ "pawn_up.png");
        drawAddPlayers();
    }

    public void init() {
        player.drawPlayer();
        player.yourTurn();
    }

    public void movePlayer(int numSteps) {
        setHasStarted();
        setTurns();
        if (getPlayer().isTurn()) {
            Runnable runnable;
            executorService.execute(() -> {
                for (int i = 0; i < numSteps; i++) {
                    getPlayer().movePlayer();
                    getPlayer().setMoveCounter();
                }
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        whoIsPlaying++;
    }
    public void addPlayer(){
        executorService.execute(() -> {
      if(hasStarted==false) {
          if (playerCount == 1) {
              player1 = new Player(635, 620, Utilities.PREFIX + "player.png", "ricardo");
              player1.drawPlayer();
              playerCount++;
          } else if (playerCount == 2) {
              player2 = new Player(635, 620, Utilities.PREFIX + "player.png", "edd");
              player2.drawPlayer();
              playerCount++;
          } else if (playerCount == 3) {
              player3 = new Player(635, 620, Utilities.PREFIX + "player.png", "ruben");
              player3.drawPlayer();
              playerCount++;
          } else if (playerCount == 4) {
              return;
          }
      } else {
          return;
      }
        });
    }
    public void setTurns() {
        if (playerCount == 1) {
            player.yourTurn();
            if (whoIsPlaying > 1) {
                whoIsPlaying = 1;
            }
        } else if (playerCount == 2) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                player1.notTurn();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                whoIsPlaying = 1;
            }
        } else if (playerCount == 3) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                player1.notTurn();
                player2.notTurn();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                player2.notTurn();
            } else if (whoIsPlaying == 3) {
                player.notTurn();
                player1.notTurn();
                player2.yourTurn();
                whoIsPlaying = 1;
            }
        } else if (playerCount == 4) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                player1.notTurn();
                player2.notTurn();
                player3.notTurn();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                player2.notTurn();
                player3.notTurn();
            } else if (whoIsPlaying == 3) {
                player.notTurn();
                player1.notTurn();
                player2.yourTurn();
                player3.notTurn();
            } else if (whoIsPlaying == 4) {
                player.notTurn();
                player1.notTurn();
                player2.notTurn();
                player3.yourTurn();
                whoIsPlaying = 1;
            }
        }
    }
    public Player getPlayer() {
        if (player.isTurn()) {
            return player;
        } else if (player1.isTurn()) {
            return player1;
        } else if (player2.isTurn()) {
            return player2;
        } else if (player3.isTurn()) {
            return player3;
        }
        return null;
    }

        public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public void drawAddPlayers(){
        addPlayers.draw();
        mouseSetup();
    }

    private void mouseSetup() {
        Mouse mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Runnable runnable;
        executorService.execute(() -> {
            if (mouseEvent.getX() >= addPlayers.getX() &&
                    mouseEvent.getX() <= addPlayers.getX() + addPlayers.getWidth() &&
                    mouseEvent.getY() >= addPlayers.getY() &&
                    mouseEvent.getY() <= addPlayers.getY() + addPlayers.getHeight()) {
                addPlayer();
            }
        });
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void setHasStarted() {
        hasStarted = true;
    }
}
