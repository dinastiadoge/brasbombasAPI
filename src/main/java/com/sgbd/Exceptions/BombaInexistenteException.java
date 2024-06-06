package com.sgbd.Exceptions;

public class BombaInexistenteException extends RuntimeException {
    public BombaInexistenteException() {
    }

    public BombaInexistenteException(String message) {
        super(message);
    }
}
