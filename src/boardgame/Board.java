package boardgame;

/**
 * Represents a game board with rows, columns, and pieces.
 * <p>
 * The {@code Board} class is used to define the layout of a game board, where
 * each location on the board can hold a {@code Piece}. It provides methods to
 * access and manipulate the pieces on the board.
 * </p>
 *
 * @see Piece
 * @see Position
 */
public class Board {

    private int rows;
    private int column;
    private Piece[][] pieces;

    /**
     * Constructs a new {@code Board} with the specified number of rows and columns.
     * <p>
     * This constructor initializes a new board with the given dimensions (rows and columns),
     * and creates a 2D array of pieces that will hold the pieces placed on the board.
     * </p>
     *
     * @param rows the number of rows on the board.
     * @param column the number of columns on the board.
     */
    public Board(int rows, int column) {
        this.rows = rows;
        this.column = column;
        pieces = new Piece[rows][column];
    }

    /**
     * Returns the number of rows on the board.
     * <p>
     * This method provides access to the number of rows in the board.
     * </p>
     *
     * @return the number of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Sets the number of rows on the board.
     * <p>
     * This method allows updating the number of rows on the board.
     * </p>
     *
     * @param rows the new number of rows to set.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Returns the number of columns on the board.
     * <p>
     * This method provides access to the number of columns in the board.
     * </p>
     *
     * @return the number of columns.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets the number of columns on the board.
     * <p>
     * This method allows updating the number of columns on the board.
     * </p>
     *
     * @param column the new number of columns to set.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Returns the piece located at the specified row and column.
     * <p>
     * This method retrieves the piece at the given position (row, column) on the board.
     * </p>
     *
     * @param row the row of the piece.
     * @param column the column of the piece.
     * @return the {@code Piece} located at the specified position.
     */
    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    /**
     * Returns the piece located at the specified position.
     * <p>
     * This method retrieves the piece at the given {@code Position} object on the board.
     * </p>
     *
     * @param position the position object representing the piece's location.
     * @return the {@code Piece} located at the specified position.
     */
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

    /**
     * Places a {@code Piece} at the specified position on the board.
     * <p>
     * This method assigns a {@code Piece} to a specific location on the board
     * and updates the piece's position.
     * </p>
     *
     * @param piece the piece to place on the board.
     * @param position the position where the piece will be placed.
     */
    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}