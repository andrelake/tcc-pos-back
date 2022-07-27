package com.tcc.tccback.model.produto;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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

    @OneToOne
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
        name = "fornecedor_produto",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "fornecedor_id"))
    private Set<Fornecedor> listaFornecedores;
}
