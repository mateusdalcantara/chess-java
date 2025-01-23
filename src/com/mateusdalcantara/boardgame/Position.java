package com.mateusdalcantara.boardgame;
/**
 * Represents a position on a board with a row and a column.
 *
 * The {@code Position} class is used to define a location on a board, with two
 * coordinates: {@code row} and {@code column}. It is commonly used in games
 * that involve a grid or matrix-based board, such as chess or other board games.
 *
 *
 * @see Board
 * @see Piece
 */
public class Position {

    /** The row of the position on the board. Represents the horizontal coordinate. */
    private int row;

    /** The column of the position on the board. Represents the vertical coordinate. */
    private int column;

    /**
     * Constructs a new {@code Position} with the specified row and column.
     *
     * This constructor initializes a position using the provided row and column
     * values, representing the location on a grid.
     *
     *
     * @param row the row of the position on the board.
     * @param column the column of the position on the board.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    /**
     * Returns the row of this position.
     *
     * This method provides access to the row coordinate of the position.
     *
     *
     * @return the row of the position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Sets the row of this position.
     * <p>
     * This method allows updating the row coordinate of the position.
     * </p>
     *
     * @param row the new row value to set.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns the column of this position.
     * <p>
     * This method provides access to the column coordinate of the position.
     * </p>
     *
     * @return the column of the position.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets the column of this position.
     * <p>
     * This method allows updating the column coordinate of the position.
     * </p>
     *
     * @param column the new column value to set.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    public void setValues(int row, int column){
        this.row = row;
        this.column = column;
    }

    /**
     * Returns a string representation of this position in the format "row, column".
     * <p>
     * This method returns a human-readable string that represents the position
     * in a simple format: "row, column".
     * </p>
     *
     * @return a string representing the position in the format "row, column".
     */
    @Override
    public String toString() {
        return row + ", " + column;
    }
}
