package com.tcc.tccback.model.produto.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoUpdateDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal precoUnitario;
    private String categoria;
    private String fornecedor;
    private boolean ativo;

    public ProdutoUpdateDTO() {
    }
}
