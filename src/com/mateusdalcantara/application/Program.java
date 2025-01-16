package com.mateusdalcantara.application;

import com.mateusdalcantara.chess.ChessMatch;
import com.mateusdalcantara.chess.ChessPiece;
import com.mateusdalcantara.chess.ChessPosition;

import java.util.Scanner;

/**
 * The entry point of the chess application.
 * <p>
 * The {@code Program} class is responsible for initializing the chess match and
 * displaying the board in the console. It creates a new instance of {@code ChessMatch}
 * and then uses the {@code UI} class to print the chessboard and its pieces.
 *
 * @see ChessMatch
 * @see UI
 * @see ChessPosition
 */
public class Program {
    /**
     * The main method that starts the chess game and prints the chessboard.
     * <p>
     * This method initializes a new chess match, retrieves the current state of the chessboard,
     * and uses the {@code UI.printBoard} method to display the board on the console.
     *
     * @param args command-line arguments (not used in this program).
     */
    public static void main(String[] args) {

        /** Object who receive the user input. */
        Scanner sc = new Scanner(System.in);

        /** Initialize a new chess match */
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            /** Print the chessboard using the UI class */
            UI.printBoard(chessMatch.getPieces());

            System.out.println();
            System.out.print("Source: ");

            /**  */
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}
