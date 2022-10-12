package com.tcc.tccback.controller.produto;

import com.tcc.tccback.model.produto.dto.ProdutoDTO;
import com.tcc.tccback.service.produto.ProdutoDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoDeleteController {

    @Autowired
    private ProdutoDeleteService deleteService;

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletar(@RequestBody ProdutoDTO dto) {
        deleteService.deletar(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
