package com.tcc.tccback.service.usuario;

import com.tcc.tccback.exception.usuario.UsuarioNaoEncontradoException;
import com.tcc.tccback.model.usuario.Usuario;
import com.tcc.tccback.model.usuario.dto.UsuarioSenhaDTO;
import com.tcc.tccback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUpdateService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioUpdateService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void updateById(UsuarioSenhaDTO usuarioSenhaDTO) {
        Usuario usuarioEncontrado = usuarioRepository.findById(usuarioSenhaDTO.getId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioSenhaDTO.getId()));

        trataUsuarioEncontrado(usuarioSenhaDTO, usuarioEncontrado);
        usuarioRepository.save(usuarioEncontrado);
    }

    private void trataUsuarioEncontrado(UsuarioSenhaDTO usuarioSenhaDTO, Usuario usuarioEncontrado) {
        usuarioEncontrado.setNomeCompleto(usuarioSenhaDTO.getNomeCompleto());
        usuarioEncontrado.setUsername(usuarioSenhaDTO.getUsername());
        usuarioEncontrado.setSenha(usuarioSenhaDTO.getSenha());
        usuarioEncontrado.setIsAdmin(usuarioSenhaDTO.getIsAdmin());
    }
}
