package com.tcc.tccback.model.usuario.dto;

import com.tcc.tccback.model.usuario.Usuario;
import lombok.Data;

@Data
public class UsuarioInsertDTO {
    private String nomeCompleto;
    private String username;
    private String senha;
    private Boolean isAdmin;

    public UsuarioInsertDTO() { }

    public UsuarioInsertDTO(Usuario usuario) {
        this.nomeCompleto = usuario.getNomeCompleto();
        this.username = usuario.getUsername();
        this.senha = usuario.getSenha();
        this.isAdmin = usuario.getIsAdmin();
    }
}
