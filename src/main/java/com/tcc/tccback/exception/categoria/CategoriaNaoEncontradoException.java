package com.tcc.tccback.exception.categoria;

import javax.persistence.EntityNotFoundException;

public class CategoriaNaoEncontradoException extends EntityNotFoundException {

    public CategoriaNaoEncontradoException() {
    }

    public CategoriaNaoEncontradoException(String message) {
        super(message);
    }

    public CategoriaNaoEncontradoException(int id) {
        super(String.format("Categoria com o id %d não encontrada.", id));
    }
}
