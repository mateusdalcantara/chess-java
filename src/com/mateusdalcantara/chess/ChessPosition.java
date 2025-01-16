package com.mateusdalcantara.chess;

import com.mateusdalcantara.boardgame.Position;


/**
 * Represents a position on a chessboard using notation.
 *
 * A position is defined by a column(from 'a' to 'h') and row (from 1 to 8).
 * This class provides methods to convert chess notation into internal board coordinates.
 *
 * It ensures that only valid chess positions (from 'a1' to 'h8') are created,
 * throwing an exception for any invalid values.
 *
 * @see Position
 * @see ChessException
 * */
public class ChessPosition {


    /**
     * The column of the chess position.
     *
     * The column is represented by a character between 'a' and 'h', where 'a'
     * represents the first column and 'h' represents the last column on a chessboard.
     *
     * Example: For position 'a1', the column is 'a'.
     *
     */
    private char column;

    /**
     * The row of the chess position.
     *
     * The row is represented by an integer between 1 and 8, where 1 represents the first row
     * and 8 represents the last row on a chessboard.
     *
     *
     * Example: For position 'a1', the row is 1.
     *
     */
    private int row;

    /**
     * Constructs a ChessPosition instance.
     *
     * this constructor ensures that the column is between 'a' and 'h'
     * and the row is between 1 and 8, throwing an exception if the values are out of bounds.
     *
     *
     * @param column column the column of the chess position (from 'a' to 'h')
     * @param row the row of the chess position (from 1 to 8)
     * @throws ChessException if the column or row is out of the valid range
     * */
    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    /** Method returns the column of the chess position.
     *
     * The column is represented by a letter from 'a' to 'h'.
     *
     *
     * @return the column of the chess position
     * */
    public char getColumn() {
        return column;
    }

    /**
     * Method returns the row of the chess position.
     *
     * The row is an integer value from 1 to 8.
     *
     *
     * @return the row of the chess position
     * */
    public int getRow() {
        return row;
    }

    /**
     * Converts the ChessPosition to a Position object.
     *
     * This method converts the chess position (e.g., 'a1') to an internal Position
     * representation, where the row is inverted (from top to bottom) and columns
     * are mapped to an integer (0 to 7).
     *
     *
     * @return the corresponding Position object
     * */
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    /**
     * Converts a Position object to a ChessPosition.
     *
     * This mehod creates a ChessPosition from an internal Position object by mapping the internal
     * position coordinates back to chess notation.
     *
     *
     * @param position the Position object to be converted
     * @return the corresponding ChessPosition object
     * @see ChessPosition
     * */
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    /**
     * Returns the chess position as a string in chess notation.
     *
     * The string will be formatted as the column letter followed by the row number (e.g., "a1").
     *
     *
     * @return the string representation of the chess position
     * */
    @Override
    public String toString(){//string vazio é macete para forçar o compilador a concatenar
        return "" + column + row; //concatenação de string
    }
}
