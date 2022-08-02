package com.tcc.tccback.controller.produto;

import com.tcc.tccback.model.produto.Produto;
import com.tcc.tccback.service.produto.ProdutoInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoInsertController {

    @Autowired
    private ProdutoInsertService produtoInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Produto produto) {
        produtoInsertService.salvar(produto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
