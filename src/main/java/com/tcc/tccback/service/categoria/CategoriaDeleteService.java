package com.tcc.tccback.service.categoria;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.categoria.dto.CategoriaDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CategoriaDeleteService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDeleteService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public void deletar(CategoriaDTO dto) {
        Optional<Categoria> categoria = categoriaRepository.findById(dto.getId());
        categoria.ifPresent(value -> categoriaRepository.delete(value));
    }
}
