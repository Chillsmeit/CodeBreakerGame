package io.codeforall.gameJam.position;

/**
 * A position on the grid that is capable of moving around
 */
public interface GridPosition {

    /**
     * Gets the position column in the grid
     *
     * @return the position column
     */
    public int getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    public int getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    public void setPos(int col, int row);

    /**
     * Displays the position in the grid
     */
    public void show();

    /**
     * Hides the position in the grid
     */
    public void hide();

    public boolean equals(GridPosition position);

}
