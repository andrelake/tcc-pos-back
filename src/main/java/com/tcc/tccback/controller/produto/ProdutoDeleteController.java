package com.tcc.tccback.controller.produto;

import com.tcc.tccback.service.produto.ProdutoDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoDeleteController {

    @Autowired
    private ProdutoDeleteService deleteService;

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> findAllProdutos(@PathVariable Integer id) {
        deleteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
