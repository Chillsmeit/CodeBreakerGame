package io.codeforall.gameJam;

import io.codeforall.gameJam.position.ChallengesDaresRewards;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private Picture player;
    private String name;
    private boolean turn;
    private int moveCounter;
    private ChallengesDaresRewards challengesDaresRewards = new ChallengesDaresRewards();

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter() {
        this.moveCounter++;
    }
    public void resetCounter(){
        this.moveCounter=0;
    }

    public Player(int col, int row, String pathToImage, String name) {
        player = new Picture(col, row, pathToImage);
        this.name = name;
    }
    public void drawPlayer(){
        player.draw();
    }

    public void moveRight() {
        player.translate(75, 0);
    }
    public void moveLeft() {
        player.translate(-75,0);
    }

    public void moveUp() {
        player.translate(0,-75);
    }

    public void moveDown() {
        player.translate(0,75);
    }

    public void movePlayer() {
        if (moveCounter>=7&&moveCounter<14){
                moveUp();

        } else if (moveCounter>=14&&moveCounter<21) {
                moveRight();
        } else if (moveCounter>=21&&moveCounter<28) {
                moveDown();
        } else if (moveCounter == 28){
            moveCounter = 0;
                moveLeft();
        } else if (moveCounter >= 0&&moveCounter < 7) {
                moveLeft();
        }
    }


    public void refreshImage() {
        player.load(Utilities.PREFIX + "pawn.png");
    }

    public boolean yourTurn() {
        return turn = true;
    }

    public void notTurn() {
        turn = false;
    }

    public String getName() {
        return name;
    }
    public Picture getPlayerPicture(){
        return player;
    }

    public boolean isTurn() {
        return turn;
    }
}
