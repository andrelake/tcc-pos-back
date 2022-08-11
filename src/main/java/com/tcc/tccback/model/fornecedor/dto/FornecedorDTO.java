package com.tcc.tccback.model.fornecedor.dto;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FornecedorDTO {

    private Integer id;
    private String nome;
    private String categoria;

    public static FornecedorDTO toFornecedorDTO(Fornecedor fornecedor) {
        return FornecedorDTO.builder()
                .id(fornecedor.getId())
                .nome(fornecedor.getNome())
                .categoria(fornecedor.getCategoria().getNome())
                .build();
    }
}
