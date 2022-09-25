package com.tcc.tccback.service.usuario;

import com.tcc.tccback.exception.usuario.UsuarioNaoEncontradoException;
import com.tcc.tccback.model.usuario.Usuario;
import com.tcc.tccback.model.usuario.dto.UsuarioDTO;
import com.tcc.tccback.model.usuario.dto.UsuarioFormDTO;
import com.tcc.tccback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioFindService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioFindService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    public Usuario findById(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public UsuarioDTO findUsuarioLogado(UsuarioFormDTO usuarioFormDTO) {
        Usuario usuario = usuarioRepository.findByUsername(usuarioFormDTO.getUsername())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        String.format("Usuário com o username '%s' não encontrado", usuarioFormDTO.getUsername())));

        return new UsuarioDTO(usuario);
    }
}
