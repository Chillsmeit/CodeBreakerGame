package io.codeforall.gameJam;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Dado implements MouseHandler {

    private Picture dado;

    public Dado (int col, int row, String pathToImage) {
        dado = new Picture(col, row, pathToImage);
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

        if (mouseEvent.getX() >= dado.getX() &&
        mouseEvent.getX() <= dado.getX() + dado.getWidth() &&
        mouseEvent.getY() >= dado.getY() &&
        mouseEvent.getY() <= dado.getY() + dado.getHeight()) {
            int numRandom = (int) Math.floor(Math.random() * 6);
            System.out.println(numRandom);
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
