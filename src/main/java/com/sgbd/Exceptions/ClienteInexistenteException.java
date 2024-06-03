package com.sgbd.Exceptions;

public class ClienteInexistenteException extends RuntimeException{

    public ClienteInexistenteException() {
        super();
    }

    public ClienteInexistenteException(String message) {
        super(message);
    }
}
