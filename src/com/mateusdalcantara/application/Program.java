package com.mateusdalcantara.application;

import com.mateusdalcantara.chess.ChessException;
import com.mateusdalcantara.chess.ChessMatch;
import com.mateusdalcantara.chess.ChessPiece;
import com.mateusdalcantara.chess.ChessPosition;

import java.util.InputMismatchException;
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
            try{

                /** Method to clean the board after moving pieces */
                UI.clearScreen();

                /** Print the chessboard using the UI class */
                UI.printBoard(chessMatch.getPieces());

                System.out.println();
                System.out.print("Source: ");

                /**
                 * Executes a chess move based on user input and performs the move on the chess match.
                 *
                 * This block of code reads two positions from the user input: a source position and a target position.
                 * Then, it attempts to perform the move from the source to the target on the chessboard.
                 * If the move is valid, the piece at the source position is moved to the target position,
                 * and any captured piece is returned.
                 *
                 *
                 * @param sc The Scanner object used to read user input.
                 * @param chessMatch The current chess match object where the move will be performed.
                 * @return The piece that was captured (if any), or null if no piece was captured.
                 * */
                ChessPosition source = UI.readChessPosition(sc); // Read the source position from user input.
                System.out.println(); // Print a blank line for readability.
                System.out.println("Target: "); // Prompt the user for the target position.
                ChessPosition target = UI.readChessPosition(sc); // Read the target position from user input.
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target); // Perform the chess move and capture any piece.

            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
