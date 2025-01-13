package boardgame;

/**
 * Represents a game board with rows, columns, and pieces.
 * <p>
 * The {@code Board} class defines the layout of a game board, where
 * each position on the board can hold a {@code Piece}. It provides methods for
 * accessing, manipulate and the pieces placed on the board.
 * </p>
 *
 * @see Piece
 * @see Position
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    /**
     * Constructs a new {@code Board} with the specified number of rows and columns.
     * <p>
     * This constructor initializes a new board with the given dimensions (rows and columns),
     * creating a 2D array to hold the pieces the pieces placed on the board.
     * </p>
     *
     * @param rows    the number of rows on the board. Must be at least 1
     * @param columns the number of columns on the board. Must be at least 1
     * @throws BoardException if the numbers of rows or columns is less than 1
     */
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    /**
     * Returns the number of rows on the board.
     * <p>
     * This method provides access to the number of rows in the board.
     * </p>
     *
     * @return the number of rows on the board.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns on the board.
     * <p>
     * This method provides access to the number of columns in the board.
     * </p>
     *
     * @return the number of columns on the board.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Returns the piece located at the specified row and column.
     * <p>
     * This method retrieves the {@code Piece} object located at the
     * specified position on the board using the provided row and column coordinates.
     * </p>
     *
     * @param row    the row of the piece.
     * @param column the column of the piece.
     * @return the {@code Piece} located at the specified row and column.
     * @throws BoardException if the position does not exist on the board.
     */
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    /**
     * Returns the piece located at the specified position.
     * <p>
     * This method retrieves the {@code Piece} object located at the position
     * specified by the {@code Position} object.
     * </p>
     *
     * @param position the {@code Position} object representing the piece's location.
     * @return the {@code Piece} located at the specified position.
     * @throws BoardException if the position does not exist on the board.
     */
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    /**
     * Places a {@code Piece} at the specified position on the board.
     * <p>
     * This method places a {@code Piece} at a specific location on the board
     * and updates the position of the piece accordingly.
     * </p>
     *
     * @param piece    the piece to place on the board.
     * @param position the position where the piece will be placed.
     * @throws BoardException if there is already a piece at the specified position.
     */
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /**
     * Checks if the given row and column are within the bound of the board.
     * <p>
     * this method verifies if the provided row and column indices are valid for
     * the current board dimensions.
     * </p>
     *
     * @param row    the row index.
     * @param column the column index.
     * @return {@code true} if the position exists on the board, {@code false} otherwise.
     */
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    /**
     * Checks if the given position is within the bounds of the board.
     * <p>
     * This method verifies if the provided {@code Position} object corresponds
     * to a valid location on the board.
     * </p>
     *
     * @param position the {@code Position} object to check.
     * @return {@code true} if the position exists on the board,
     * {@code false} otherwise.
     */
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    /**
     * Checks if there is a piece at the specified position.
     * <p>
     * This method verifies whether a piece exists at the given position on the board.
     * </p>
     *
     * @param position the position to check.
     * @return {@code true} if there is a piece at the position, {@code false} otherwise.
     * @throws BoardException if the position does not exist on the board.
     */
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}