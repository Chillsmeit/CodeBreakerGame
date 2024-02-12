package io.codeforall.gameJam.position;

import io.codeforall.gameJam.Grid;

public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col   the column of the grid position
     * @param row   the row of the grid position
     * @param grid  the grid in which the position will be displayed
     */
    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */
    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    /**
     * @see GridPosition#getCol()
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

    public abstract void moveInDirection(int distance);
}
