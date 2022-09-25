package com.tcc.tccback.model.usuario.dto;

import com.tcc.tccback.model.usuario.Usuario;
import lombok.Data;

@Data
public class UsuarioSenhaDTO {
    private Integer id;
    private String nomeCompleto;
    private String username;
    private String senha;
    private Boolean isAdmin;

    public UsuarioSenhaDTO() { }

    public UsuarioSenhaDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nomeCompleto = usuario.getNomeCompleto();
        this.username = usuario.getUsername();
        this.senha = usuario.getSenha();
        this.isAdmin = usuario.getIsAdmin();
    }
}
