package com.tcc.tccback.controller.categoria;

import com.tcc.tccback.model.categoria.dto.CategoriaDTO;
import com.tcc.tccback.service.categoria.CategoriaFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/categoria")
public class CategoriaFindController {

    @Autowired
    private CategoriaFindService categoriaFindService;

    @GetMapping(value = "/todos")
    public ResponseEntity<List<CategoriaDTO>> findAllCategorias() {
        return new ResponseEntity<>(categoriaFindService.findAll(),HttpStatus.OK);
    }
}
