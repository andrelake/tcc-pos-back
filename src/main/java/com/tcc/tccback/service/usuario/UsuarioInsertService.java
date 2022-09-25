package com.tcc.tccback.service.usuario;

import com.tcc.tccback.model.usuario.Usuario;
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
    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
