package com.tcc.tccback.controller.categoria;

import com.tcc.tccback.model.categoria.dto.CategoriaDTO;
import com.tcc.tccback.service.categoria.CategoriaUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/categoria")
public class CategoriaUpdateController {

    @Autowired
    private CategoriaUpdateService categoriaUpdateService;

    @PutMapping("/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody CategoriaDTO categoria) {
        categoriaUpdateService.updateById(categoria);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
