package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.graphics.Text;
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

    private int whoIsPlaying = 0;

    private boolean hasStarted = false;

    private Text text = new Text(950, 100, "");

    public Game() {
        executorService = Executors.newFixedThreadPool(2);
        player = new Player(630, 620, Utilities.PREFIX + "PlayerBlue.png", "Player 1");
        player = new Player(630, 620, Utilities.PREFIX + "PlayerBlue.png", "Player Blue");
        text.setText(getNamePlayer());
        text.grow(50, 50);
        text.draw();
        init();
        addPlayers = new Picture(250, 700, Utilities.PREFIX + "AddPlayer.png");
        drawAddPlayers();
    }

    public void init() {
        player.drawPlayer();
        player.yourTurn();
    }

    public void movePlayer(int numSteps) {
        if(playerCount==1&&player.isWin()){
        return;
        } else if (playerCount==2&&(player.isWin()||player1.isWin())) {
            return;
        } else if (playerCount==3&&(player.isWin()|| player1.isWin()|| player2.isWin())){
            return;
        }else if (playerCount==4&&(player.isWin()|| player1.isWin()||player2.isWin()|| player3.isWin())){
            return;
        }
        setHasStarted();
        setTurns();
        whoIsPlaying++;
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
        if (getPlayer().getPlayerPicture().getX()==630&&getPlayer().getPlayerPicture().getY()==620){
            getPlayer().setWin();
            if(player.isWin()) {
                Picture winscreen = new Picture(10,10,Utilities.PREFIX+"WinScreen-blue-player-alt.png");
                winscreen.draw();
            } else if (player1.isWin()) {
                Picture winscreen = new Picture(10,10,Utilities.PREFIX+"WinScreen-gold-player-alt.png");
                winscreen.draw();
            } else if (player2.isWin()) {
                Picture winscreen = new Picture(10,10,Utilities.PREFIX+"WinScreen-green-player-alt.png");
                winscreen.draw();
            } else if (player3.isWin()) {
                Picture winscreen = new Picture(10,10,Utilities.PREFIX+"WinScreen-white-player-alt.png");
                winscreen.draw();
            }
        }
    }

    public void addPlayer() {
        executorService.execute(() -> {
            if (!hasStarted) {
                if (playerCount == 1) {
                    player1 = new Player(630, 620, Utilities.PREFIX + "PlayerGold.png", "Player 2");
                    player1 = new Player(630, 620, Utilities.PREFIX + "PlayerGold.png", "Player Gold");
                    text.delete();
                    text.setText(getNamePlayer1());
                    text.draw();
                    player1.drawPlayer();
                    playerCount++;
                } else if (playerCount == 2) {
                    player2 = new Player(630, 620, Utilities.PREFIX + "PlayerGreen.png", "Player 3");
                    player2 = new Player(630, 620, Utilities.PREFIX + "PlayerGreen.png", "Player Green");
                    text.delete();
                    text.setText(getNamePlayer2());
                    text.draw();
                    player2.drawPlayer();
                    playerCount++;
                } else if (playerCount == 3) {
                    player3 = new Player(630, 620, Utilities.PREFIX + "PlayerWhite.png", "Player 4");
                    player3 = new Player(630, 620, Utilities.PREFIX + "PlayerWhite.png", "Player White");
                    text.delete();
                    text.setText(getNamePlayer3());
                    text.draw();
                    player3.drawPlayer();
                    playerCount++;
                }
            }
        });
    }

    public void setTurns() {
        if (playerCount == 1) {
            player.yourTurn();
            text.delete();
            text.setText(getNamePlayer());
            text.draw();
            if (whoIsPlaying > 1) {
                whoIsPlaying = 0;
            }
        } else if (playerCount == 2) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                text.delete();
                text.setText(getNamePlayer());
                text.draw();
                player1.notTurn();
                text.delete();
                text.setText(getNamePlayer());
                text.draw();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                text.delete();
                text.setText(getNamePlayer1());
                text.draw();
                whoIsPlaying = 0;
            }
        } else if (playerCount == 3) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                text.delete();
                text.setText(getNamePlayer());
                text.draw();
                player1.notTurn();
                player2.notTurn();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                text.delete();
                text.setText(getNamePlayer1());
                text.draw();
                player2.notTurn();
            } else if (whoIsPlaying == 3) {
                player.notTurn();
                player1.notTurn();
                player2.yourTurn();
                text.delete();
                text.setText(getNamePlayer2());
                text.draw();
                whoIsPlaying = 0;
            }
        } else if (playerCount == 4) {
            if (whoIsPlaying == 1) {
                player.yourTurn();
                text.delete();
                text.setText(getNamePlayer());
                text.draw();
                player1.notTurn();
                player2.notTurn();
                player3.notTurn();
            } else if (whoIsPlaying == 2) {
                player.notTurn();
                player1.yourTurn();
                text.delete();
                text.setText(getNamePlayer1());
                text.draw();
                player2.notTurn();
                player3.notTurn();
            } else if (whoIsPlaying == 3) {
                player.notTurn();
                player1.notTurn();
                player2.yourTurn();
                text.delete();
                text.setText(getNamePlayer2());
                text.draw();
                player3.notTurn();
            } else if (whoIsPlaying == 4) {
                player.notTurn();
                player1.notTurn();
                player2.notTurn();
                player3.yourTurn();
                text.delete();
                text.setText(getNamePlayer3());
                text.draw();
                whoIsPlaying = 0;
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

    public String getNamePlayer() {
        return player.getName();
    }

    public String getNamePlayer1() {
        return player1.getName();
    }

    public String getNamePlayer2() {
        return player2.getName();
    }

    public String getNamePlayer3() {
        return player3.getName();
    }

    public void drawAddPlayers() {
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
