package com.sgbd.Exceptions;

public class CompraInexistenteException extends RuntimeException {
    public CompraInexistenteException() {
        super();
    }

    public CompraInexistenteException(String message) {
        super(message);
    }
}
