package com.tcc.tccback.model.usuario.dto;

import com.tcc.tccback.model.usuario.Usuario;
import lombok.Data;

@Data
public class UsuarioFormDTO {
    private String username;
    private String senha;

    public UsuarioFormDTO() { }

    public UsuarioFormDTO(Usuario usuario) {
        this.username = usuario.getUsername();
        this.senha = usuario.getSenha();
    }
}
