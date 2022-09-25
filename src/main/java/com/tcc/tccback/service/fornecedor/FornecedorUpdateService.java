package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.exception.fornecedor.FornecedorNaoEncontradoException;
import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorFormDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void updateById(FornecedorFormDTO fornecedorDTO) {
        Fornecedor fornecedorEncontrado = fornecedorRepository.findByNome(fornecedorDTO.getNome())
                .orElseThrow(() -> new FornecedorNaoEncontradoException(fornecedorDTO.getNome()));

        tratafornecedorEncontrado(fornecedorDTO, fornecedorEncontrado);
        fornecedorRepository.save(fornecedorEncontrado);
    }

    private void tratafornecedorEncontrado(FornecedorFormDTO fornecedorDTO, Fornecedor fornecedorEncontrado) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(fornecedorDTO.getCategoria());

        fornecedorEncontrado.setNome(fornecedorDTO.getNome());
        fornecedorEncontrado.setCategoria(categoria.get());
    }
}
