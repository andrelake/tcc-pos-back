package com.tcc.tccback.exception.fornecedor;

import javax.persistence.EntityNotFoundException;

public class FornecedorNaoEncontradoException extends EntityNotFoundException {

    public FornecedorNaoEncontradoException() {
    }

    public FornecedorNaoEncontradoException(String message) {
        super(message);
    }

    public FornecedorNaoEncontradoException(int id) {
        super(String.format("Fornecedor com o id %d não encontrado.", id));
    }
}
