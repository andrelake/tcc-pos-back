package com.tcc.tccback.model.fornecedor;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToOne()
    private Categoria categoria;

    @ManyToMany(mappedBy = "listaFornecedores")
    private List<Produto> listaProdutos;
}
