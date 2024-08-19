package com.rtarcisio.usersandnotify.service;

import com.rtarcisio.usersandnotify.domain.Usuario;
import com.rtarcisio.usersandnotify.domain.enums.StatusUsuarioEnum;
import com.rtarcisio.usersandnotify.dtos.RegisterDTO;
import com.rtarcisio.usersandnotify.repository.UsuarioRepository;
import com.rtarcisio.usersandnotify.service.exceptions.ObjetoNaoRemovidoException;
import com.rtarcisio.usersandnotify.service.exceptions.UsuarioNaoEncontradoException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public Usuario salvarUser(@Valid RegisterDTO data) {

//        if(this.usuarioRepository.findByEmail(data.email()) != null)
//            throw new RuntimeException("Usuario já cadastado.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario aCadastrar = new Usuario(data.nome(), data.email(), encryptedPassword, data.cpf(), data.dataNascimento());
        aCadastrar = usuarioRepository.save(aCadastrar);

        return aCadastrar;
    }

    public void deletarUsuario(Long id) {

        Usuario usuario = buscarPorId(id);

        if (usuario.getStatusUsuario() == StatusUsuarioEnum.DESATIVADO) {
            throw new ObjetoNaoRemovidoException("Não é possivel exluir o usuario.");
        }

        usuario.setStatusUsuario(StatusUsuarioEnum.DESATIVADO);
//        saveLogControl(usuario, modificationEnum.EXCLUSAO, Constantes.DELETA_USUARIO);
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
    }

    public Usuario buscarPorCpf(String cpf) {
        Optional<Usuario> obj = usuarioRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
    }

    public Usuario buscarPorEmail(String email) {
        Optional<Usuario> obj = usuarioRepository.findByEmail(email);
        return obj.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
    }
}
