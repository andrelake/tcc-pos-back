package com.tcc.tccback.service.usuario;

import com.tcc.tccback.exception.usuario.UsuarioNaoEncontradoException;
import com.tcc.tccback.model.usuario.Usuario;
import com.tcc.tccback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDeleteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDeleteService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void deleteById(int id) {
        usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        usuarioRepository.deleteById(id);
    }

}
