package com.mateusdalcantara.chess.pieces;

import com.mateusdalcantara.boardgame.Board;
import com.mateusdalcantara.chess.ChessPiece;
import com.mateusdalcantara.chess.Color;


/**
 * Represents a King chess piece.
 * <p>
 * The {@code King} class defines the behavior and properties of the King piece
 * in a chess game. A King can move one square in any direction, and is the most
 * important piece in the game. The game ends if the King is checkmated.
 * </p>
 *
 * @see ChessPiece
 * @see Board
 * @see Color
 */
public class King extends ChessPiece {

    /**
     * Constructs a King piece with the specified color on the given board.
     * <p>
     * This constructor initializes the King piece by calling the parent class
     * constructor with the specified board and color.
     * </p>
     *
     * @param board the {@code Board} on which the King piece is placed.
     * @param color the {@code Color} of the King piece (either white or black).
     */
    public King(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns a string representation of the King piece.
     * <p>
     * This method returns the character "K" to represent the King piece.
     * </p>
     *
     * @return the string "K" representing the King.
     */
    @Override
    public String toString() {
        return "K";
    }

    /**
     *
     * Calculates the possible moves for the King piece.
     * <p>
     * This method returns a 2D array of boolean values, where each cell represents
     * a square on the board.
     * The value {@code true} indicates that the square is a valid move for the King,
     * while {@code false} indicates an invalid move.
     * <p>
     * The King can move horizontally and vertically any number of squares, as long as
     * the path is not blocked by other pieces.
     * </p>
     *
     * @return a 2D array representing the possible moves for the King piece.
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
