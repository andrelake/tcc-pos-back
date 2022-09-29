package com.tcc.tccback.controller.usuario;

import com.tcc.tccback.model.usuario.dto.UsuarioInsertDTO;
import com.tcc.tccback.service.usuario.UsuarioInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioInsertController {

    @Autowired
    private UsuarioInsertService usuarioInsertService;

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody UsuarioInsertDTO usuarioInsertDTO) {
        usuarioInsertService.salvar(usuarioInsertDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
