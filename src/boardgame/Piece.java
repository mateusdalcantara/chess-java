package boardgame;

/**
 * Represents a game piece that is placed on a board.
 * <p>
 * The {@code Piece} class is used as a base class for any piece that can be placed
 * on a board. It holds a reference to the {@code Board} where the piece is located,
 * and a {@code Position} that indicates the piece's location on the board.
 * </p>
 *
 * @see Board
 * @see Position
 */

public class Piece {

    protected Position position;
    private Board board;

    /**
     * Constructs a new {@code Piece} associated with a given {@code Board}.
     * <p>
     * The constructor initializes the piece with a reference to the board where it will be placed.
     * </p>
     *
     * @param board the board where the piece is located.
     */
    public Piece(Board board) {
        this.board = board;
    }

    /**
     * Returns the board where this piece is located.
     * <p>
     * This method allows access to the board that the piece belongs to.
     * </p>
     *
     * @return the board where the piece is located.
     */
    protected Board getBoard() {
        return board;
    }
}
