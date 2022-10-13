package com.tcc.tccback.model.fornecedor.dto;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FornecedorProdsDTO {

    private Integer id;
    private String nome;
    private String categoria;
    private boolean temProdutos;
    private boolean ativo;

    public static FornecedorProdsDTO toFornecedorProdsDTO(Fornecedor fornecedor) {
        return FornecedorProdsDTO.builder()
                .id(fornecedor.getId())
                .nome(fornecedor.getNome())
                .categoria(fornecedor.getCategoria().getNome())
                .temProdutos(!fornecedor.getListaProdutos().isEmpty())
                .ativo(fornecedor.isAtivo())
                .build();
    }
}
