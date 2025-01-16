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

public class Piece {

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
}
