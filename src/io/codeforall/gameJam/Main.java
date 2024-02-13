package io.codeforall.gameJam;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(10, 700);
        game.init();

        Players player = new Players(new Picture(200,200,"resources/pawn.png"));
        player.draw();
    }

}
