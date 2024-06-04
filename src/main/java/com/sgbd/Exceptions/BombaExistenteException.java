package com.sgbd.Exceptions;

public class BombaExistenteException extends RuntimeException{

    public BombaExistenteException() {
        super();
    }

    public BombaExistenteException(String message) {
        super(message);
    }
}
