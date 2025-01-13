package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

/**
 * The entry point of the chess application.
 * <p>
 * The {@code Program} class is responsible for initializing the chess match and
 * displaying the board in the console. It creates a new instance of {@code ChessMatch}
 * and then uses the {@code UI} class to print the chessboard and its pieces.
 * </p>
 *
 * @see ChessMatch
 * @see UI
 */
public class Program {
    /**
     * The main method that starts the chess game and prints the chessboard.
     * <p>
     * This method initializes a new chess match, retrieves the current state of the chessboard,
     * and uses the {@code UI.printBoard} method to display the board on the console.
     * </p>
     *
     * @param args command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch(); // Initialize a new chess match
        UI.printBoard(chessMatch.getPieces()); // Print the chessboard using the UI class
    }
}
