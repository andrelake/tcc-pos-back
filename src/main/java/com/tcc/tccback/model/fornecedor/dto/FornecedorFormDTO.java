package com.tcc.tccback.model.fornecedor.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FornecedorFormDTO {

    private String nome;
    private String categoria;
}
