package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FornecedorInsertService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorInsertService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public void salvar(Fornecedor fornecedor) {
            fornecedorRepository.save(fornecedor);
    }
}
