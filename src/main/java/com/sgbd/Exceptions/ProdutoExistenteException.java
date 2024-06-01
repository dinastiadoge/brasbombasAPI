package com.sgbd.Exceptions;

public class ProdutoExistenteException extends RuntimeException{

    public ProdutoExistenteException() {
        super();
    }

    public ProdutoExistenteException(String message) {
        super(message);
    }
}
