package com.sgbd.Exceptions;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException() {
    }

    public ValorInvalidoException(String message) {
        super(message);
    }
}
