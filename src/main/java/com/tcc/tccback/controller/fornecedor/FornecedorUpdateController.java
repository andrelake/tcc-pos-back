package com.tcc.tccback.controller.fornecedor;

import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.service.fornecedor.FornecedorUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/fornecedor")
public class FornecedorUpdateController {

    @Autowired
    private FornecedorUpdateService fornecedorUpdateService;

    @PutMapping("/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody FornecedorDTO fornecedorForm) {
        fornecedorUpdateService.updateById(fornecedorForm);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
