package com.mateusdalcantara.chess;

import com.mateusdalcantara.boardgame.Board;
import com.mateusdalcantara.boardgame.Piece;

/**
 * Represent a ChessPiece on chess board.
 *
 * The {@code chessPiece} class is a subclass of {@code Piece} that adds
 * functionality, such as color, to the chess piece. This class serves as a base
 * for chess pieces like (Rook, King, Knight, etc), each of which has a color associated
 * to distinguish between players.
 *
 *
 * @see Piece
 * @see Board
 * @see Color
 * */
public abstract class ChessPiece extends Piece {

    /** The color of the chess pieces on the board for the chess match. */
    private Color color;


    /**
     *  This constructor build a chess piece with specific color.
     *
     * @param board is the location where the piece will be set.
     * @param color set the piece color (Black or White).
     * */
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    /**
     *  Return the piece color
     *
     * @return color of the chess piece (Black or White).
     * */
    public Color getColor() {
        return color;
    }

}
