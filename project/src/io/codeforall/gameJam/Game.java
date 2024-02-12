package io.codeforall.gameJam;

public class Game {

    private Grid grid;
    private int delay;

    public Game (int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;
    }

    public void init() {
        grid.init();
    }

    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(delay);
        }
    }

}
