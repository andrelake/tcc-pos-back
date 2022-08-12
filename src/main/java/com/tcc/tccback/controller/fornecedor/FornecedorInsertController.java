package com.tcc.tccback.controller.fornecedor;

import com.tcc.tccback.model.fornecedor.dto.FornecedorFormDTO;
import com.tcc.tccback.service.fornecedor.FornecedorInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/fornecedor")
public class FornecedorInsertController {

    @Autowired
    private FornecedorInsertService fornecedorInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody FornecedorFormDTO fornecedorForm) {
        fornecedorInsertService.salvar(fornecedorForm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
