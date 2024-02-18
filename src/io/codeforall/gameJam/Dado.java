package io.codeforall.gameJam;

import io.codeforall.gameJam.position.BoardPositions;
import io.codeforall.gameJam.position.ChallengesDaresRewards;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dado implements MouseHandler {
    private final ExecutorService executorService;
    private Picture dado;
    private Game game = new Game();
    private BoardPositions boardPositions = new BoardPositions();
    private ChallengesDaresRewards challengesDaresRewards = new ChallengesDaresRewards();
    private Text text = new Text(800, 180, "");

    int col = 322;
    int row = 470;


    public Dado(String pathToImage) {
        dado = new Picture(col, row, pathToImage);
        executorService = Executors.newFixedThreadPool(1);
        text.grow(10, 10);
    }

    public void drawDado() {
        dado.draw();
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
            if (mouseEvent.getX() >= dado.getX() &&
                    mouseEvent.getX() <= dado.getX() + dado.getWidth() &&
                    mouseEvent.getY() >= dado.getY() &&
                    mouseEvent.getY() <= dado.getY() + dado.getHeight()) {
                int numRandom = (int) Math.ceil(Math.random() * 6);
                System.out.println(numRandom);

                if (numRandom == 1) {
                    dado.load( Utilities.PREFIX + "Dice1TOP.png");
                } else if (numRandom == 2) {
                    dado.load( Utilities.PREFIX + "Dice2TOP.png");
                } else if (numRandom == 3)  {
                    dado.load(Utilities.PREFIX + "Dice3TOP.png");
                } else if (numRandom == 4) {
                    dado.load(Utilities.PREFIX + "Dice4TOP.png");
                } else if (numRandom == 5) {
                    dado.load( Utilities.PREFIX + "Dice5TOP.png");
                } else {
                    dado.load(Utilities.PREFIX + "Dice6TOP.png");
                }

                game.movePlayer(numRandom);
                for (int i = 0; i <boardPositions.getPx().length; i++) {
                    if (game.getPlayer().getPlayerPicture().getX()==boardPositions.getPx()[i]&&game.getPlayer().getPlayerPicture().getY()==boardPositions.getPy()[i]){
                        int[] bx = boardPositions.getPx();
                        int[] by = boardPositions.getPy();
                        if ((bx[i]==bx[1]&&by[i]==by[1])||(bx[i]==bx[3]&&by[i]==by[3])||(bx[i]==bx[6]&&by[i]==by[6])||(bx[i]==bx[10]&&by[i]==by[10])||(bx[i]==bx[12]&&by[i]==by[12])||(bx[i]==bx[15]&&by[i]==by[15])||(bx[i]==bx[17]&&by[i]==by[17])||(bx[i]==bx[19]&&by[i]==by[19])||(bx[i]==bx[22]&&by[i]==by[22])||(bx[i]==bx[24]&&by[i]==by[24])||(bx[i]==bx[27]&&by[i]==by[27])){
                            String penaltis = challengesDaresRewards.getPenalties();
                            text.setText(penaltis);
                            text.draw();
                        } else if ((bx[i]==bx[2]&&by[i]==by[2])||(bx[i]==bx[5]&&by[i]==by[5])||(bx[i]==bx[8]&&by[i]==by[8])||(bx[i]==bx[11]&&by[i]==by[11])||(bx[i]==bx[16]&&by[i]==by[16])||(bx[i]==bx[20]&&by[i]==by[20])||(bx[i]==bx[23]&&by[i]==by[23])||(bx[i]==bx[26]&&by[i]==by[26])) {
                            String challenges = challengesDaresRewards.getChallenges();
                            text.delete();
                            text.setText(challenges);
                            text.draw();
                        } else if ((bx[i]==bx[4]&&by[i]==by[4])||(bx[i]==bx[9]&&by[i]==by[9])||(bx[i]==bx[13]&&by[i]==by[13])||(bx[i]==bx[18]&&by[i]==by[18])||(bx[i]==bx[25]&&by[i]==by[25])) {
                            String rewards = challengesDaresRewards.getRewards();
                            text.delete();
                            text.setText(rewards);
                            text.draw();
                        } else if (bx[i]==bx[7]&&by[i]==by[7]) {
                            String zuka = challengesDaresRewards.getZuka();
                            text.delete();
                            text.setText(zuka);
                            text.draw();
                        } else if (bx[i]==bx[14]&&by[i]==by[14]) {
                            String mic = challengesDaresRewards.getMic();
                            text.delete();
                            text.setText(mic);
                            text.draw();
                        } else if (bx[i]==bx[21]&&by[i]==by[21]) {
                            String mariana = challengesDaresRewards.getMariana();
                            text.delete();
                            text.setText(mariana);
                            text.draw();
                        }
                    }
                }

            }
        });
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
