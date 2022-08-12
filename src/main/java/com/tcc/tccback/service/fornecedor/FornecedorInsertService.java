package com.tcc.tccback.service.fornecedor;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorFormDTO;
import com.tcc.tccback.repository.CategoriaRepository;
import com.tcc.tccback.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FornecedorInsertService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public FornecedorInsertService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public void salvar(FornecedorFormDTO fornecedorForm) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(fornecedorForm.getCategoria());

        if(categoria.isPresent()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(fornecedorForm.getNome());
            fornecedor.setCategoria(categoria.get());
            fornecedorRepository.save(fornecedor);
        }
    }
}
