package com.mateusdalcantara.chess;

import com.mateusdalcantara.boardgame.Board;
import com.mateusdalcantara.boardgame.Piece;
import com.mateusdalcantara.boardgame.Position;
import com.mateusdalcantara.chess.pieces.King;
import com.mateusdalcantara.chess.pieces.Rook;

/**
 * Represent a match of chess, including the board and pieces.
 *
 * A class {@code ChessMatch} manages the chess match, including the board
 * configuring the position of the pieces. It allows the access to the pieces
 * on the board and organizes their position.
 *
 * @see Board
 * @see ChessPiece
 * @see Rook
 * @see King
 * @see ChessException
 */
public class ChessMatch {

    /**
     * The game board for the chess match, which holds the pieces and their positions.
     */
    private Board board;

    /**
     * This constructor starts a chess match and builds the chess board.
     *
     * The board is created with 8 lines and 8 column, and
     * the pieces will be placed on the board. Their positions are defined by the {@code initialSetup} method.
     */
    public ChessMatch() {
        board = new Board(8, 8); //numbers of rows and columns in chess board
        initialSetup(); //set the initial positions of the pieces
    }

    /**
     * Returns the chess pieces on the board.
     *
     * This method iterates over the board and returns a matrix representing the pieces.
     * Each position in the matrix corresponds to a square on the board (rows 0-7, columns 0-7).
     * The chess pieces are cast from {@code Piece} to {@code ChessPiece}.
     *
     * @return a matrix containing the chess pieces on the board.
     */
    public ChessPiece[][] getPieces() { //moving pieces in the board
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j); // Converts Piece to ChessPiece
            }
        }
        return mat;
    }


    /**
     * Executes a move in the chess match
     *
     * This method performs a move from a source position to a target position,
     * validates the source position, and updates the board. If a piece is captured, it is returned.
     *
     * @param sourcePosition the position of the piece to move.
     * @param targetPosition the position to move the piece to.
     * @return the captured {@code ChessPiece}, or {@code null} if no piece was captured.
     * @throws ChessException if the move is invalid or the source position does not contain a piece.
     * */
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    /**
     * Makes a move from the soucer position to the target position on the board.
     *
     * This method removes the piece from the source position, moves it to the target position,
     * and return any captured piece.
     *
     * @param source the source position of the piece.
     * @param target the target position where the piece is moved.
     * @return the captured {@code Piece}, or {@code null} if no piece was captured.
     * */
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    /**
     * Validates that the source position contains a piece.
     *
     * This method checks if there is a piece at the given source position.
     *
     * @param position the position to check.
     * @throws ChessException if there is no piece at the source position.
     * */
    private void validateSourcePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position.");
        }
    }

    /**
     * Places a new chess piece on the board at the specified position.
     *
     * This method simplifies the placement of chess pieces by converting the
     * given board position (in chess notation) into an internal position format.
     *
     * The column is represented by a letter (e.g., 'a', 'b', 'c', etc.), and the
     * row is a number (1-8). The method maps the column from chess notation into
     * an integer index, where 'a' maps to 0, 'b' maps to 1, and so on.
     *
     * Example of column conversion:
     *
     *    'a' - 'a' = 0
     *    'b' - 'a' = 1
     *    'c' - 'a' = 2
     *     . . . . . .
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
     *
     * This method set positions the pieces on the chessboard. The {@code Rook}
     * are placed, and the {@code King} are placed.
     *
     * @see Rook
     * @see King
     */
    private void initialSetup() {

        /** Column = a-h, Row = 1-8 */
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
