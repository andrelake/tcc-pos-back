package com.tcc.tccback.controller.login;

import com.tcc.tccback.model.usuario.dto.UsuarioDTO;
import com.tcc.tccback.model.usuario.dto.UsuarioFormDTO;
import com.tcc.tccback.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/autenticaUsuario")
    public ResponseEntity<UsuarioDTO> autenticaUsuario(@RequestBody UsuarioFormDTO usuarioFormDTO) {
        return new ResponseEntity<UsuarioDTO>(loginService.autenticaUsuario(usuarioFormDTO), HttpStatus.OK);
    }
}
