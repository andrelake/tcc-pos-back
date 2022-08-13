package com.tcc.tccback.controller.categoria;

import com.tcc.tccback.model.categoria.Categoria;
import com.tcc.tccback.service.categoria.CategoriaInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/categoria")
public class CategoriaInsertController {

    @Autowired
    private CategoriaInsertService categoriaInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Categoria categoria) {
        categoriaInsertService.salvar(categoria);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
