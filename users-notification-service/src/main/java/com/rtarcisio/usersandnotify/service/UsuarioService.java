package com.rtarcisio.usersandnotify.service;

import com.rtarcisio.usersandnotify.domain.Country;
import com.rtarcisio.usersandnotify.domain.Usuario;
import com.rtarcisio.usersandnotify.domain.enums.StatusUsuarioEnum;
import com.rtarcisio.usersandnotify.dtos.FollowedCountryDto;
import com.rtarcisio.usersandnotify.dtos.RegisterDTO;
import com.rtarcisio.usersandnotify.dtos.UsuarioCountriesDto;
import com.rtarcisio.usersandnotify.dtos.UsuarioDto;
import com.rtarcisio.usersandnotify.repository.UsuarioRepository;
import com.rtarcisio.usersandnotify.service.exceptions.ObjetoNaoRemovidoException;
import com.rtarcisio.usersandnotify.service.exceptions.UsuarioNaoEncontradoException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public UsuarioCountriesDto followcountry(List<Country> toFollow ) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(usuario != null) {
            usuario.setFollowedCountries(toFollow);

            usuarioRepository.save(usuario);
        }
        UsuarioCountriesDto userDto = addFollowedCountries(toFollow);
        userDto.setId(usuario.getId());
        userDto.setNome(usuario.getNome());
        userDto.setEmail(usuario.getEmail());

        return userDto;

    }

    public List<Usuario> queSeguemPais(String countryCode){
        List<Usuario> usuarios = usuarioRepository.findAllByFollowedCountries_Code(countryCode);
        return usuarios;
    }

    private UsuarioCountriesDto addFollowedCountries(List<Country> toFollow) {
        UsuarioCountriesDto userDto = new UsuarioCountriesDto();
        List<Long> followed = new ArrayList<>();
        for(Country country : toFollow) {
            followed.add(country.getId());
        }
        userDto.setFollowedCountryIds(followed);

        return userDto;
    }

    private UsuarioDto convert (Usuario user){
        return new UsuarioDto(user.getNome(), user.getEmail());
    }
}
