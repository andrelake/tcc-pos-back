package com.tcc.tccback.service.login;

import com.tcc.tccback.model.usuario.Usuario;
import com.tcc.tccback.model.usuario.dto.UsuarioDTO;
import com.tcc.tccback.model.usuario.dto.UsuarioFormDTO;
import com.tcc.tccback.service.usuario.UsuarioFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioFindService usuarioFindService;

    public UsuarioDTO autenticaUsuario(UsuarioFormDTO usuarioFormDTO) {
        Usuario usuarioLogado = usuarioFindService.findUsuarioLogadoEntity(usuarioFormDTO);

        if(!usuarioLogado.getSenha().equals(usuarioFormDTO.getSenha()))
            return null;

        return new UsuarioDTO(usuarioLogado);
    }
}
