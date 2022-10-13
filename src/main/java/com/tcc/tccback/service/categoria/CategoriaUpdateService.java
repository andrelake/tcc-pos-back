package com.tcc.tccback.service.categoria;

import com.tcc.tccback.exception.categoria.CategoriaNaoEncontradoException;
import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.categoria.dto.CategoriaDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaUpdateService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaUpdateService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void updateById(CategoriaDTO categoriaDTO) {
        Categoria categoriaEncontrada = categoriaRepository.findById(categoriaDTO.getId())
                .orElseThrow(() -> new CategoriaNaoEncontradoException(categoriaDTO.getNome()));

        tratacategoriaEncontrado(categoriaDTO, categoriaEncontrada);
        categoriaRepository.save(categoriaEncontrada);
    }

    private void tratacategoriaEncontrado(CategoriaDTO categoriaDTO, Categoria categoriaEncontrada) {
        categoriaEncontrada.setNome(categoriaDTO.getNome());
    }
}
