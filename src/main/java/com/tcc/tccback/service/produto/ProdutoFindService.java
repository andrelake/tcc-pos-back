package com.tcc.tccback.service.produto;

import com.tcc.tccback.exception.produto.ProdutoNaoEncontradoException;
import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.model.produto.dto.ProdutoDTO;
import com.tcc.tccback.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoFindService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoFindService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public Produto findById(int id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

}
