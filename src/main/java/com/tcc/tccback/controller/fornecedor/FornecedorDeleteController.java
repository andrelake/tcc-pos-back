package com.tcc.tccback.controller.fornecedor;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.service.fornecedor.FornecedorDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/fornecedor")
public class FornecedorDeleteController {

    @Autowired
    private FornecedorDeleteService fornecedorDeleteService;

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletar(@RequestBody FornecedorDTO fornecedorDTO) {
        fornecedorDeleteService.deletar(fornecedorDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
