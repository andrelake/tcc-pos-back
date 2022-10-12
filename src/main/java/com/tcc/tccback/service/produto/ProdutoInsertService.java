package com.tcc.tccback.service.produto;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.model.produto.dto.ProdutoFormDTO;
import com.tcc.tccback.repository.ProdutoRepository;
import com.tcc.tccback.service.categoria.CategoriaFindService;
import com.tcc.tccback.service.fornecedor.FornecedorFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProdutoInsertService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaFindService categoriaFindService;
    @Autowired
    private FornecedorFindService fornecedorFindService;

    public ProdutoInsertService(ProdutoRepository produtoRepository,
                                CategoriaFindService categoriaFindService,
                                FornecedorFindService fornecedorFindService) {
        this.produtoRepository = produtoRepository;
        this.categoriaFindService = categoriaFindService;
        this.fornecedorFindService = fornecedorFindService;
    }

    @Transactional
    public void salvar(ProdutoFormDTO formDTO) {
        Produto novoProduto = criaProdutoDoFormDTO(formDTO);
        produtoRepository.save(novoProduto);
    }

    private Produto criaProdutoDoFormDTO(ProdutoFormDTO formDTO) {
        Categoria categoriaEncontrada = categoriaFindService.findByNome(formDTO.getCategoria());
        Fornecedor fornecedorEncontrado = fornecedorFindService.findByNome(formDTO.getFornecedor());

        Produto novoProduto = new Produto();
        novoProduto.setNome(formDTO.getNome());
        novoProduto.setDescricao(formDTO.getDescricao());
        novoProduto.setQuantidade(formDTO.getQuantidade());
        novoProduto.setPrecoUnitario(formDTO.getPrecoUnitario());
        novoProduto.setCategoria(categoriaEncontrada);
        novoProduto.setFornecedor(fornecedorEncontrado);
        return novoProduto;
    }

}
