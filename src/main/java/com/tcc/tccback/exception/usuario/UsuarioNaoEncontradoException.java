package com.tcc.tccback.exception.usuario;

import com.tcc.tccback.exception.EntidadeNaoEncontradaException;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(Integer id) {
        this(String.format("Não existe um cadastro de Usuário com o código %d", id));
    }
}
