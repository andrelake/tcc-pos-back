package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FornecedorDeleteService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorDeleteService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public void deletar(FornecedorDTO dto) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(dto.getId());
        fornecedor.ifPresent(value -> fornecedorRepository.delete(value));
    }
}
