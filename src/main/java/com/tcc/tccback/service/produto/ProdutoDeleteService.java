package com.tcc.tccback.service.produto;

import com.tcc.tccback.exception.produto.ProdutoNaoEncontradoException;
import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.model.produto.dto.ProdutoDTO;
import com.tcc.tccback.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoDeleteService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDeleteService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void deleteById(int id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        produtoRepository.deleteById(id);
    }

    public void deletar(ProdutoDTO dto) {
        Optional<Produto> produto = produtoRepository.findById(dto.getId());
        produto.ifPresent(value -> produtoRepository.delete(value));
    }

}
