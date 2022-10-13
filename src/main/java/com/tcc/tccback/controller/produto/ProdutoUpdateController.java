package com.tcc.tccback.controller.produto;

import com.tcc.tccback.model.produto.dto.ProdutoUpdateDTO;
import com.tcc.tccback.service.produto.ProdutoUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoUpdateController {

    @Autowired
    private ProdutoUpdateService produtoUpdateService;

    @PutMapping("/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody ProdutoUpdateDTO produtoDTO) {
        produtoUpdateService.update(produtoDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
