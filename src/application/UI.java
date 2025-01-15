package application;

import chess.ChessPiece;
import chess.Color;

/**
 * A utility class for handling the display of the chessboard in the console.
 * <p>
 * The {@code UI} class provides methods for printing the chessboard and its pieces
 * in a user-readable format. The board is displayed with rows numbered from 8 to 1,
 * and columns labeled with letters from 'a' to 'h'. Empty positions are represented
 * by a hyphen ("-"), and each chess piece is represented by its string representation.
 * </p>
 *
 * @see ChessPiece
 */
public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    /**
     * Prints the chessboard to the console, displaying each piece in its corresponding position.
     * <p>
     * This method loops through the 2D array of {@code ChessPiece} objects and prints the board
     * with row numbers and column letters. Empty spaces on the board are represented by a hyphen ("-").
     * </p>
     *
     * @param pieces a 2D array of {@code ChessPiece} objects representing the chessboard.
     */
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " "); // Print the row number (from 8 to 1)
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]); // Print each piece or "-" if no piece is present
            }
            System.out.println();
        }
        System.out.print("  a  b  c  d  e  f  g  h"); // Print the column labels

    }

    /**
     * Prints a single chess piece or a hyphen if the position is empty.
     * <p>
     * This helper method is used by {@code printBoard} to print each piece in its string representation,
     * or a hyphen ("-") if the square is empty (i.e., no piece is present at that position).
     * </p>
     *
     * @param piece the {@code ChessPiece} to be printed, or {@code null} if there is no piece at the position.
     */
    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
