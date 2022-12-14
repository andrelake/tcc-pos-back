package com.tcc.tccback.controller.fornecedor;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.model.fornecedor.dto.FornecedorProdsDTO;
import com.tcc.tccback.service.fornecedor.FornecedorFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/fornecedor")
public class FornecedorFindController {

    @Autowired
    private FornecedorFindService fornecedorFindService;

    @GetMapping(value = "/todos")
    public ResponseEntity<List<FornecedorDTO>> findAllFornecedors() {
        return new ResponseEntity<>(fornecedorFindService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<FornecedorProdsDTO> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(fornecedorFindService.findById(id),HttpStatus.OK);
    }
}
