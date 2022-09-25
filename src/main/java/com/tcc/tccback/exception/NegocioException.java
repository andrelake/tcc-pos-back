package com.tcc.tccback.exception;

public class NegocioException extends RuntimeException{
    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
