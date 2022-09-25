package com.tcc.tccback.model.usuario.dto;

import com.tcc.tccback.model.usuario.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
    private String nomeCompleto;
    private String username;
    private Boolean isAdmin;

    public UsuarioDTO() { }

    public UsuarioDTO(Usuario usuario) {
        this.nomeCompleto = usuario.getNomeCompleto();
        this.username = usuario.getUsername();
        this.isAdmin = usuario.getIsAdmin();
    }
}
