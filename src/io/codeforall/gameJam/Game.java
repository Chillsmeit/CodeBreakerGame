package io.codeforall.gameJam;

public class Game {

    private Grid grid;
    private Background background;

    public Game (int cols, int rows) {
        grid = GridFactory.makeGrid(cols, rows);
        background = new Background(cols, rows, Utilities.PREFIX + "tabuleiro.jpg");
    }

    public void init() {
        grid.init();
        background.drawBackground();
    }

}
