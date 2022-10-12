package com.tcc.tccback.controller.produto;

import com.tcc.tccback.model.produto.dto.ProdutoFormDTO;
import com.tcc.tccback.service.produto.ProdutoInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoInsertController {

    @Autowired
    private ProdutoInsertService produtoInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody ProdutoFormDTO produto) {
        produtoInsertService.salvar(produto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
