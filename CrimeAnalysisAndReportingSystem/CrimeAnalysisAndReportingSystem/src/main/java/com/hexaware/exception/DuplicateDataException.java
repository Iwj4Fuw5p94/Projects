package com.hexaware.exception;

/**
 * Custom exception class indicating that duplicate data has been entered.
 * This exception is thrown when an attempt is made to add data that already exists.
 */
public class DuplicateDataException extends Exception {

    /**
     * Constructs a new DuplicateDataException with a default error message.
     */
    public DuplicateDataException() {
        System.out.println("Duplicate Data Exception");
    }

    /**
     * Returns a string representation of the exception.
     *
     * @return A string representation of the exception.
     */
    @Override
    public String toString() {
        return "Duplicate Data Entered!!";
    }
}
