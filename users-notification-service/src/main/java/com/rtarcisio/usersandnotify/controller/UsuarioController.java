package com.rtarcisio.usersandnotify.controller;


import com.rtarcisio.usersandnotify.security.TokenService;
import com.rtarcisio.usersandnotify.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

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
