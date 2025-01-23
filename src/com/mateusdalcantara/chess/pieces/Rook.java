package com.mateusdalcantara.chess.pieces;

import com.mateusdalcantara.boardgame.Board;
import com.mateusdalcantara.boardgame.Position;
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


    /**
     * Calculates the possible moves for the Rook piece.
     * <p>
     * This method returns a 2D array of boolean values, where each cell represents a square
     * on the board. The value {@code true} indicates that the square is a valid move for the Rook,
     * while {@code false} indicates an invalid move.
     * <p>
     * The Rook can move horizontally and vertically any number of squares, as long as the path
     * is not blocked by other pieces.
     * </p>
     *
     * @return a 2D array representing the possible moves for the Rook piece.
     */
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);

        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);

        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);

        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);

        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }



        return mat;
    }
}
