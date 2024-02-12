package io.codeforall.gameJam.gfx;

import io.codeforall.gameJam.position.AbstractGridPosition;
import io.codeforall.gameJam.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(grid.columnToX(getCol()), grid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        show();
    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    @Override
    public void moveInDirection(int distance) {

        int initialCol = getCol();
        int initialRow = getRow();
        int finalCol = getCol();
        int finalRow = getRow();

        int diffX = simpleGfxGrid.columnToX(finalCol) - simpleGfxGrid.columnToX(initialCol);
        int diffY = simpleGfxGrid.rowToY(finalRow) - simpleGfxGrid.rowToY(initialRow);

        rectangle.translate(diffX, diffY);
    }

}
