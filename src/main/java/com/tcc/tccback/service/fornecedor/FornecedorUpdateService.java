package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.exception.categoria.CategoriaNaoEncontradoException;
import com.tcc.tccback.exception.fornecedor.FornecedorNaoEncontradoException;
import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorUpdateService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public FornecedorUpdateService(FornecedorRepository fornecedorRepository,
                                   CategoriaRepository categoriaRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void updateById(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedorEncontrado = fornecedorRepository.findById(fornecedorDTO.getId())
                .orElseThrow(() -> new FornecedorNaoEncontradoException(fornecedorDTO.getNome()));

        trataFornecedorEncontrado(fornecedorDTO, fornecedorEncontrado);
        fornecedorRepository.save(fornecedorEncontrado);
    }

    private void trataFornecedorEncontrado(FornecedorDTO fornecedorDTO, Fornecedor fornecedorEncontrado) {
        Categoria categoria = categoriaRepository.findByNome(fornecedorDTO.getCategoria())
                .orElseThrow(() -> new CategoriaNaoEncontradoException(fornecedorDTO.getCategoria()));

        fornecedorEncontrado.setNome(fornecedorDTO.getNome());
        fornecedorEncontrado.setCategoria(categoria);
    }
}
