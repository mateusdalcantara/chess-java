package com.mateusdalcantara.chess;

import com.mateusdalcantara.boardgame.BoardException;

/**
 * Exception class for handling errors specific to the chess game logic.
 *
 * The {@code ChessException} class extends {@link BoardException} to represent
 * errors that occur during the execution of a chess game, such as invalid moves
 * or other game-related issues.
 *
 *
 * @see BoardException
 */
public class ChessException extends BoardException {

    /** Unique identifier for serialization */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@code ChessException} with the specified detail message.
     *
     * This constructor initializes the exception with a specific message
     * that describes the error in more detail.
     *
     *
     * @param msg the detail message that describes the exception.
     */
    public ChessException(String msg){
        super(msg); // Call to the superclass constructor with the message
    }
}