package com.mateusdalcantara.application;

import com.mateusdalcantara.chess.ChessPiece;
import com.mateusdalcantara.chess.ChessPosition;
import com.mateusdalcantara.chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A utility class for handling the display of the chessboard in the console.
 *
 * The {@code UI} class provides methods for printing the chessboard and its pieces
 * in a user-readable format. The board is displayed with rows numbered from 8 to 1,
 * and columns labeled with letters from 'a' to 'h'. Empty positions are represented
 * by a hyphen ("-"), and each chess piece is represented by its string representation.
 * The class also handles color coding for the chess piece (white and black).
 *
 *
 * @see ChessPiece
 */
public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    // ANSI escape codes for setting text and background colors in the console
    /**
     * Resets the color formatting in the console.
     * This code is used to reset text color and background color after printing.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * ANSI escape code for black text color.
     */
    public static final String ANSI_BLACK = "\u001B[30m";

    /**
     * ANSI escape code for red text color.
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * ANSI escape code for green text color.
     */
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * ANSI escape code for yellow text color.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * ANSI escape code for blue text color.
     */
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * ANSI escape code for purple text color.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";

    /**
     * ANSI escape code for cyan text color.
     */
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * ANSI escape code for white text color.
     */
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * ANSI escape code for black background color.
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    /**
     * ANSI escape code for red background color.
     */
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    /**
     * ANSI escape code for green background color.
     */
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    /**
     * ANSI escape code for yellow background color.
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    /**
     * ANSI escape code for blue background color.
     */
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    /**
     * ANSI escape code for purple background color.
     */
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    /**
     * ANSI escape code for cyan background color.
     */
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    /**
     * ANSI escape code for white background color.
     */
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";



    //https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
    /**
     * This method clean the terminal after use.
     *
     * This method send an ANSI escape sequence to the terminal to clear the screen and
     * move the cursor to the top-left corner. It is typically used to clean the console
     * display when running a command-line application.
     *
     * Note: This method may not work in all environments. It is designed for terminals
     * that support ANSI escape codes, such as most Linux and macOS terminals. On Windows,
     * it may require a PowerShell or some emulators(Git Bash and Windows Terminal).
     *
     * */
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc){

        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
        }
    }

    /**
     * Prints the chessboard to the console, displaying each piece in its corresponding position.
     *
     * This method iterates through the 2D array of {@code ChessPiece} objects and prints the chessboard
     * in a human-readable format. Row numbers are printed from 8 to 1, and columns are labeled from 'a' to 'h'.
     * Empty squares are represented by a hyphen ("-").
     *
     *
     * @param pieces A 2D array of {@code ChessPiece} objects representing the current state of the chessboard.
     *               Each element in the array corresponds to a square on the chessboard, which may contain a piece
     *               or be empty (null).
     *
     * @see ChessPiece
     */
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " "); // Print the row number (from 8 to 1)
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]); // Print each piece or "-" if no piece is present
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h"); // Print the column labels

    }

    /**
     * Prints a single chess piece or a hyphen if the position is empty.
     *
     * This helper method is used by {@code printBoard} to print each piece in its string representation,
     * or a hyphen ("-") if there is no piece at that position.
     *
     *
     * @param piece The {@code ChessPiece} to be printed, or {@code null} if the position is empty (no piece present).
     */
    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            // Print a hyphen if the square is empty
            System.out.print("-");
        } else {
            // Print piece with appropriate color (white or black)
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET); // White pieces are printed in white
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET); // Black pieces are printed in yellow
            }
        }
        System.out.print(" "); // Print a space after each piece for separation
    }
}

