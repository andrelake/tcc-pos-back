package com.tcc.tccback.service.categoria;

import com.tcc.tccback.exception.categoria.CategoriaNaoEncontradoException;
import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.categoria.dto.CategoriaDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaFindService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaFindService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTO::toCategoriaDTO)
                .collect(Collectors.toList());
    }

    public Categoria findById(int id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradoException(id));
    }

    public Categoria findByNome(String texto) {
        return categoriaRepository.findByNome(texto).orElseThrow(() -> new CategoriaNaoEncontradoException(
                String.format("Categoria com o nome %s não foi encontrada.", texto))
        );
    }
}
