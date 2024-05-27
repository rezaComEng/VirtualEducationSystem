package org.example;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException(){
        super();
    }

    public InvalidIDException(String message) {
        super(message);
    }
}
