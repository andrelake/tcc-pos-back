package com.tcc.tccback.controller.produto;

import com.tcc.tccback.model.produto.dto.ProdutoDTO;
import com.tcc.tccback.service.produto.ProdutoFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoFindController {

    @Autowired
    private ProdutoFindService produtoFindService;

    @GetMapping(value = "todos")
    public ResponseEntity<List<ProdutoDTO>> findAllProdutos() {
        return new ResponseEntity<>(produtoFindService.findAll(),HttpStatus.OK);
    }
}
