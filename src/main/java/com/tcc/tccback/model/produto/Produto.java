package com.tcc.tccback.model.produto;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal precoUnitario;

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
}
