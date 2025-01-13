package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 *  Represent a ChessPiece on chess board.
 *  <p>
 *      The {@code chessPiece} class is a subclass of {@code Piece} that adds
 *      functionality, such as color, to the chess piece. This class serves as a base
 *      for chess pieces like (Rook, King, Knight, etc), each of which has a color associated
 *      to distinguish between players.
 *  </p>
 *
 * @see Piece
 * @see Board
 * @see Color
 * */
public class ChessPiece extends Piece {

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
