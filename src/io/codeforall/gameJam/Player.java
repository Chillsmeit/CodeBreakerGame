package io.codeforall.gameJam;

import io.codeforall.gameJam.position.ChallengesDaresRewards;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
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
        Text text = new Text(1000, 100, name);
        text.setColor(Color.BLACK);
        text.grow(50, 50);
        text.draw();
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
        String message = "";
        if (moveCounter >= 7 && moveCounter < 14){
                moveUp();

        } else if (moveCounter >= 14 && moveCounter < 21) {
                moveRight();

                if (moveCounter == 16 || moveCounter == 20) {
                    message = challengesDaresRewards.getChallenges();
                } else if (moveCounter == 18) {
                    message = challengesDaresRewards.getRewards();
                } else {
                    message = challengesDaresRewards.getPenalties();
                }

        } else if (moveCounter >= 21 && moveCounter < 28) {
                moveDown();

                if (moveCounter == 23 || moveCounter == 26) {
                    message = challengesDaresRewards.getChallenges();
                } else if (moveCounter == 25) {
                    message = challengesDaresRewards.getRewards();
                } else {
                    message = challengesDaresRewards.getPenalties();
                }

        } else if (moveCounter == 28){
            moveCounter = 0;
            message = "Game Over!";
                //moveLeft();

        } else if (moveCounter >= 0&&moveCounter < 7) {
                moveLeft();

                if(moveCounter == 2 || moveCounter == 5) {
                    message = challengesDaresRewards.getChallenges();
                } else if(moveCounter == 4) {
                    message = challengesDaresRewards.getRewards();
                } else {
                    message = challengesDaresRewards.getPenalties();
                }
        }
        System.out.println(message);
    }

    public void refreshImage() {
        player.load(Utilities.PREFIX + "pawn.png");
    }

    public boolean yourTurn() {
        return turn = true;
    }

    public void turnOf() {
        turn = false;
    }

    public String getName() {
        return name;
    }


}
