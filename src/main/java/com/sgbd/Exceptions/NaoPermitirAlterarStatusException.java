package com.sgbd.Exceptions;

public class NaoPermitirAlterarStatusException extends RuntimeException {
    public NaoPermitirAlterarStatusException() {
        super();
    }
     public NaoPermitirAlterarStatusException(String msg) {
        super(msg);
     }
}
