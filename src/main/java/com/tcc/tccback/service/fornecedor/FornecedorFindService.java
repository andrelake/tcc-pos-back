package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.exception.categoria.CategoriaNaoEncontradoException;
import com.tcc.tccback.exception.fornecedor.FornecedorNaoEncontradoException;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FornecedorFindService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorFindService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<FornecedorDTO> findAll() {
        return fornecedorRepository.findAll()
                .stream()
                .map(FornecedorDTO::toFornecedorDTO)
                .collect(Collectors.toList());
    }

    public Fornecedor findById(int id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new FornecedorNaoEncontradoException(id));
    }

    public Set<Fornecedor> findByIdIn(List<Integer> fornecedoresIds) {
        List<Long> listaEmLong = fornecedoresIds.stream().map(id -> (long) id).collect(Collectors.toList());
        return new HashSet<>(fornecedorRepository.findByIdIn(listaEmLong));
    }

    public Fornecedor findByNome(String texto) {
        return fornecedorRepository.findByNome(texto).orElseThrow(() -> new CategoriaNaoEncontradoException(
                String.format("Fornecedor com o nome %s não foi encontrado.", texto))
        );
    }
}
