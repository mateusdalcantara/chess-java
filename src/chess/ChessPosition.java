package chess;

import boardgame.BoardException;
import boardgame.Position;


/**
 * Represents a position on a chessboard using notation.
 * <p>
 * A position is defined by a column(from 'a' to 'h') and row (from 1 to 8).
 * This class provides methods to convert chess notation into internal board coordinates.
 *
 * It ensures that only valid chess positions (from 'a1' to 'h8') are created,
 * throwing an exception for any invalid values.
 * </p>
 * @see Position
 * @see ChessException
 * */
public class ChessPosition {
    private char column;
    private int row;

    /**
     * Constructs a ChessPosition instance.
     * <p>
     * this constructor ensures that the column is between 'a' and 'h'
     * and the row is between 1 and 8, throwing an exception if the values are out of bounds.
     * </p>
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
     * <p>
     * The column is represented by a letter from 'a' to 'h'.
     * </p>
     *
     * @return the column of the chess position
     * */
    public char getColumn() {
        return column;
    }

    /**
     * Method returns the row of the chess position.
     * <p>
     * The row is an integer value from 1 to 8.
     * </p>
     *
     * @return the row of the chess position
     * */
    public int getRow() {
        return row;
    }

    /**
     * Converts the ChessPosition to a Position object.
     * <p>
     * This method converts the chess position (e.g., 'a1') to an internal Position
     * representation, where the row is inverted (from top to bottom) and columns
     * are mapped to an integer (0 to 7).
     * </p>
     *
     * @return the corresponding Position object
     * */
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    /**
     * Converts a Position object to a ChessPosition.
     * <p>
     * This mehod creates a ChessPosition from an internal Position object by mapping the internal
     * position coordinates back to chess notation.
     * </p>
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
     * <p>
     * The string will be formatted as the column letter followed by the row number (e.g., "a1").
     * </p>
     *
     * @return the string representation of the chess position
     * */
    @Override
    public String toString(){//string vazio é macete para forçar o compilador a concatenar
        return "" + column + row; //concatenação de string
    }
}
