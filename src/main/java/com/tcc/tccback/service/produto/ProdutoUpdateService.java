package com.tcc.tccback.service.produto;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.model.produto.dto.ProdutoUpdateDTO;
import com.tcc.tccback.repository.ProdutoRepository;
import com.tcc.tccback.service.categoria.CategoriaFindService;
import com.tcc.tccback.service.fornecedor.FornecedorFindService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoUpdateService {

    private ProdutoRepository produtoRepository;
    private ProdutoFindService produtoFindService;
    private CategoriaFindService categoriaFindService;
    private FornecedorFindService fornecedorFindService;

    public ProdutoUpdateService(ProdutoRepository produtoRepository,
                                ProdutoFindService produtoFindService,
                                CategoriaFindService categoriaFindService,
                                FornecedorFindService fornecedorFindService) {
        this.produtoRepository = produtoRepository;
        this.produtoFindService = produtoFindService;
        this.categoriaFindService = categoriaFindService;
        this.fornecedorFindService = fornecedorFindService;
    }

    public void update(ProdutoUpdateDTO produtoDTO) {
        Produto produtoEncontrado = produtoFindService.findById(produtoDTO.getId());
        Categoria categoriaEncontrada = categoriaFindService.findByNome(produtoDTO.getCategoria());
        Fornecedor fornecedorEncontrado =  fornecedorFindService.findByNome(produtoDTO.getFornecedor());

        produtoEncontrado.setNome(produtoDTO.getNome());
        produtoEncontrado.setDescricao(produtoDTO.getDescricao());
        produtoEncontrado.setQuantidade(produtoDTO.getQuantidade());
        produtoEncontrado.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        produtoEncontrado.setCategoria(categoriaEncontrada);
        produtoEncontrado.setFornecedor(fornecedorEncontrado);
        produtoEncontrado.setAtivo(produtoDTO.isAtivo());

        produtoRepository.save(produtoEncontrado);
    }
}
