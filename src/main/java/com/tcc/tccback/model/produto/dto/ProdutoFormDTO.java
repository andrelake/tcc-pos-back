package com.tcc.tccback.model.produto.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoFormDTO {

    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal precoUnitario;
    private String categoria;
    private String fornecedor;
}
