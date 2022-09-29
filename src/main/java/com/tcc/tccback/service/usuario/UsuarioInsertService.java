package com.tcc.tccback.service.usuario;

import com.tcc.tccback.model.usuario.Usuario;
import com.tcc.tccback.model.usuario.dto.UsuarioInsertDTO;
import com.tcc.tccback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioInsertService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioInsertService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void salvar(UsuarioInsertDTO usuarioInsertDTO) {

        System.out.println("Criando usuario");

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNomeCompleto(usuarioInsertDTO.getNomeCompleto());
        novoUsuario.setUsername(usuarioInsertDTO.getUsername());
        novoUsuario.setSenha(usuarioInsertDTO.getSenha());
        novoUsuario.setIsAdmin(usuarioInsertDTO.getIsAdmin());
        usuarioRepository.save(novoUsuario);

        System.out.println("Usuario salvo com sucesso");
    }
}
