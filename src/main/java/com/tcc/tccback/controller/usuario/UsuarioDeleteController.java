package com.tcc.tccback.controller.usuario;

import com.tcc.tccback.model.fornecedor.dto.FornecedorDTO;
import com.tcc.tccback.model.usuario.dto.UsuarioDTO;
import com.tcc.tccback.model.usuario.dto.UsuarioFormDTO;
import com.tcc.tccback.service.usuario.UsuarioDeleteService;
import com.tcc.tccback.service.usuario.UsuarioFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioDeleteController {

    @Autowired
    private UsuarioDeleteService deleteService;

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletar(@RequestBody UsuarioDTO usuarioDTO) {
        deleteService.deleteUser(usuarioDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
