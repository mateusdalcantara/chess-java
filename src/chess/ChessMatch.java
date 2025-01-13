package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Represent a match of chess, including the board and pieces.
 * <p>
 * A class {@code ChessMatch} manages the chess match, including the board
 * configuring the position of the pieces. It allows the access to the pieces
 * on the board and organizes their position.
 * </p>
 *
 * @see Board
 * @see ChessPiece
 * @see Rook
 * @see King
 */

public class ChessMatch {

    private Board board;


    /**
     * This constructor starts a chess match and builds the chess board.
     * <p>
     * The board is created with 8 lines and 8 column, and
     * the pieces will be placed on the board. Their positions are defined by the
     * {@code initialSetup} method.
     * </p>
     */
    public ChessMatch() {
        board = new Board(8, 8); //numbers of rows and columns in chess board
        initialSetup();
    }

    /**
     * Return the chess pieces on the board.
     * <p>
     * this method iterates over the board and
     * returns a matrix representing the pieces on the board.
     * The chess pieces are converted from {@code Piece} to {@code ChessPiece}.
     * </p>
     *
     * @return a matrix containing the chess pieces on the board.
     */

    public ChessPiece[][] getPieces() { //moving pieces in the board
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumn()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumn(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    /**
     * Sets up the initial configuration of the match, placing the
     * pieces on the board.
     * <p>
     * This method set positions the pieces on the chessboard. The {@code Rook}
     * is placed at position (2, 1), and the {@code King} are placed at position (0, 4) and
     * (7, 4).
     * </p>
     */

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));

    }
}
