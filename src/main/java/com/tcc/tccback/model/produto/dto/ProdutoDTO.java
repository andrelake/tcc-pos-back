package com.tcc.tccback.model.produto.dto;

import com.tcc.tccback.model.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private String categoria;
    private int quantidade;
    private BigDecimal precoUnitario;
}
