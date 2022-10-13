package com.tcc.tccback.model.fornecedor;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private boolean ativo = true;

    @JoinColumn(name = "categoria_id")
    @ManyToOne()
    private Categoria categoria;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private List<Produto> listaProdutos = new ArrayList<>();
}
