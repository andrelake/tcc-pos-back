package com.tcc.tccback.model.categoria.dto;

import com.tcc.tccback.model.categoria.Categoria;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaDTO {
    
    private Integer id;
    private String nome;
    private boolean ativo;

    public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .ativo(categoria.isAtivo())
                .build();
    }
}
