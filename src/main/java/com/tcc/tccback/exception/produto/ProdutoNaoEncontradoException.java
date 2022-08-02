package com.tcc.tccback.exception.produto;

import javax.persistence.EntityNotFoundException;

public class ProdutoNaoEncontradoException extends EntityNotFoundException {

    public ProdutoNaoEncontradoException() {
    }

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }

    public ProdutoNaoEncontradoException(int id) {
        super(String.format("Produto com o id %d não encontrado.", id));
    }
}
