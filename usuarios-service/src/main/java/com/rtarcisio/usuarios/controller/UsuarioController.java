package com.rtarcisio.usuarios.controller;


import com.rtarcisio.usuarios.domain.Usuario;
import com.rtarcisio.usuarios.dtos.AuthenticationDTO;
import com.rtarcisio.usuarios.dtos.LoginResponseDTO;
import com.rtarcisio.usuarios.dtos.RegisterDTO;
import com.rtarcisio.usuarios.repository.UsuarioRepository;
import com.rtarcisio.usuarios.security.TokenService;
import com.rtarcisio.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;


    @GetMapping("/status")
    public String statusApi(){
        return "OK";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}
