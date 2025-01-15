package chess;

import boardgame.Board;
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
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    /**
     * Places a new chess piece on the board at the specified position.
     * <p>
     * This method simplifies the placement of chess pieces by converting the
     * given board position (in chess notation) into an internal position format.
     * The column is represented by a letter (e.g., 'a', 'b', 'c', etc.), and the
     * row is a number (1-8). The method maps the column from chess notation into
     * an integer index, where 'a' maps to 0, 'b' maps to 1, and so on.
     * </p>
     *
     * <p>
     * Example of column conversion:
     * <ul>
     *     <li>'a' - 'a' = 0</li>
     *     <li>'b' - 'a' = 1</li>
     *     <li>'c' - 'a' = 2</li>
     *     <li> . . . . . . </li>
     * </ul>
     * </p>
     *
     * @param column the column (in chess notation, a, b, c...) where the piece should be placed
     * @param row the row (1-8) where the piece should be placed
     * @param piece the chess piece to be placed on the board
     * @see ChessPosition
     */
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    /**
     * Sets up the initial configuration of the match, placing the
     * pieces on the board.
     * <p>
     * This method set positions the pieces on the chessboard. The {@code Rook}
     * are placed at position (b, 6), and the {@code King} are placed at position (e, 8).
     * </p>
     *
     * @see Rook
     * @see King
     */
    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }
}
