package com.tcc.tccback.controller.fornecedor;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.service.fornecedor.FornecedorInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorInsertController {

    @Autowired
    private FornecedorInsertService fornecedorInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Fornecedor Fornecedor) {
        fornecedorInsertService.salvar(Fornecedor);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
