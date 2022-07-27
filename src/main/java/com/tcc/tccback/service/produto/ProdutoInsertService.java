package com.tcc.tccback.service.produto;

import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoInsertService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoInsertService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}