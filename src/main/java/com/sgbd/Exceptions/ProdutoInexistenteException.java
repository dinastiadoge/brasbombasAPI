package com.sgbd.Exceptions;

public class ProdutoInexistenteException extends RuntimeException{
    public ProdutoInexistenteException() {
        super();
    }

    public ProdutoInexistenteException(String message) {
        super(message);
    }
}
