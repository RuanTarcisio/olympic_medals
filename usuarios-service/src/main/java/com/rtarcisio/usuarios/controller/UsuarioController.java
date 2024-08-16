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

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/auth")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @GetMapping("/status")
    public String statusApi(){
        return "OK";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        Usuario newUser = service.salvarUser(data);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}
