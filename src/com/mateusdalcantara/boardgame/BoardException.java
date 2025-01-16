package com.mateusdalcantara.boardgame;

/**
 * Custom exception for errors related to the game board.
 * This class extends {@link RuntimeException} and provides a way
 * to throw exceptions specific to the game board context.
 *
 */
public class BoardException extends RuntimeException {

    /** Unique identifier for serialization */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to create an instance of {@code BoardException}
     * with the specified error message.
     *
     * @param msg The error message to be associated with the exception.
     */
    public BoardException(String msg){
        super(msg);
    }
}
