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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final UsuarioRepository repository;

    private final UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
//        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        Usuario newUser = service.salvarUser(data);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
