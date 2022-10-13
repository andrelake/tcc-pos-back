package com.tcc.tccback.service.categoria;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.categoria.dto.CategoriaFormDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoriaInsertService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaInsertService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public void salvar(CategoriaFormDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        categoriaRepository.save(categoria);
    }
}
