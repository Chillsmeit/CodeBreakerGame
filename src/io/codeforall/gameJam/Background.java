package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background implements Runnable {

    public static int originalTileSize=32;

    final static double scale= 1.0;

    public static int PADDING=10;

    public static int tileSize=(int)(originalTileSize*scale);

    static public final int maxScreenCol=24;

    static public final int maxScreenRow=18;

    public static final int screenWidth=tileSize*(maxScreenCol);

    public static final int screenHeight=tileSize*(maxScreenRow);

    private Picture background;

    public Background(int cols, int rows, String pathToImage) {
        background = new Picture(cols, rows, pathToImage);
    }

    public void drawBackground() {
        background.draw();
    }


    @Override
    public void run() {

    }
}
