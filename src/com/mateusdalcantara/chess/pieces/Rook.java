package com.mateusdalcantara.chess.pieces;

import com.mateusdalcantara.boardgame.Board;
import com.mateusdalcantara.chess.ChessPiece;
import com.mateusdalcantara.chess.Color;

/**
 * Represents a Rook chess piece.
 * <p>
 * The {@code Rook} class defines the behavior and properties of the Rook piece
 * in a chess game. The Rook can move horizontally or vertically any number of squares,
 * and it is one of the most powerful pieces on the board.
 * </p>
 *
 * @see ChessPiece
 * @see Board
 * @see Color
 */
public class Rook extends ChessPiece {

    /**
     * Constructs a Rook piece with the specified color on the given board.
     * <p>
     * This constructor initializes the Rook piece by calling the parent class
     * constructor with the specified board and color.
     * </p>
     *
     * @param board the {@code Board} on which the Rook piece is placed.
     * @param color the {@code Color} of the Rook piece (either white or black).
     */
    public Rook(Board board, Color color) {
        super(board, color);
    }

    /**
     * Returns a string representation of the Rook piece.
     * <p>
     * This method returns the character "R" to represent the Rook piece.
     * </p>
     *
     * @return the string "R" representing the Rook.
     */
    @Override
    public String toString() {
        return "R";
    }
}
