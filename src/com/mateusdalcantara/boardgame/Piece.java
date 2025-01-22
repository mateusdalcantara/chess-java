package com.mateusdalcantara.boardgame;

/**
 * Represents a game piece that is placed on a board.
 *
 * The {@code Piece} class is used as a base class for any piece that can be placed
 * on a board. It holds a reference to the {@code Board} where the piece is located,
 * and a {@code Position} that indicates the piece's location on the board.
 *
 *
 * @see Board
 * @see Position
 */

public abstract class Piece {

    // The position on the board.
    protected Position position;
    // Represent a variable to instantiate the board
    private Board board;

    /**
     * Constructs a new {@code Piece} associated with a given {@code Board}.
     *
     * The constructor initializes the piece with a reference to the board where it will be placed.
     *
     *
     * @param board the board where the piece is located.
     */
    public Piece(Board board) {
        this.board = board;
    }

    /**
     * Returns the board where this piece is located.
     *
     * This method allows access to the board that the piece belongs to.
     *
     *
     * @return the board where the piece is located.
     */
    protected Board getBoard() {
        return board;
    }

    /**
     * Abstract method to calculate the possible moves for a piece.
     * <p>
     * This method is meant to be implemented by subclasses to define the specific movement logic for each type of piece.
     * It returns a 2D boolean array where each cell indicates whether a move is possible on that position.
     * </p>
     *
     * @return a 2D array of boolean values representing the possible moves for a piece.
     */
    public abstract boolean[][] possibleMoves();

    /**
     * Checks if a given position is a valid move for the piece.
     * <p>
     * This is a hook method that uses the abstract {@code possibleMoves} method to determine if the piece can move to
     * the specified position. It checks if the row and column of the given position are marked as valid moves in the
     * {@code possibleMoves} array.
     * </p>
     *
     * @param position the position to check for a possible move.
     * @return {@code true} if the position is a valid move for the piece, {@code false} otherwise.
     */
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
        // This is a hook method that delegates the actual logic to the abstract possibleMoves method
        // following the template method pattern.
    }

    /**
     * Checks if the piece has at least one possible move.
     * <p>
     * This method iterates through the array of possible moves, returned by the {@code possibleMoves} method,
     * to check if any valid move exists. If at least one valid move is found, it returns {@code true}. Otherwise,
     * it returns {@code false}.
     * </p>
     *
     * @return {@code true} if there is at least one valid move available for the piece, {@code false} otherwise.
     */
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
        // This method demonstrates how a concrete method can rely on an abstract class to implement the actual move checking logic.
    }
}
