package com.tcc.tccback.model.produto.dto;

import com.tcc.tccback.model.produto.Produto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal precoUnitario;
    private String categoria;
    private String fornecedor;

    public ProdutoDTO() {
    }

    public ProdutoDTO (Produto produto) {
        this.setId(produto.getId());
        this.setNome(produto.getNome());
        this.setDescricao(produto.getDescricao());
        this.setQuantidade(produto.getQuantidade());
        this.setPrecoUnitario(produto.getPrecoUnitario());
        this.setCategoria(produto.getCategoria().getNome());
        this.setFornecedor(produto.getFornecedor().getNome());
    }
}
