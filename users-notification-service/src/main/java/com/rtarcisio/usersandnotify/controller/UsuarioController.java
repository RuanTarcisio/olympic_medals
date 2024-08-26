package com.rtarcisio.usersandnotify.controller;


import com.rtarcisio.usersandnotify.domain.Usuario;
import com.rtarcisio.usersandnotify.dtos.FollowedCountryDto;
import com.rtarcisio.usersandnotify.dtos.UsuarioCountriesDto;
import com.rtarcisio.usersandnotify.security.TokenService;
import com.rtarcisio.usersandnotify.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    private final UsuarioService usuarioService;


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
    @PutMapping("/follow-country")
    private ResponseEntity<UsuarioCountriesDto> followedCountry(@RequestBody List<Long> toFollow  /*@RequestBody FollowedCountryDto dto*/){
        FollowedCountryDto dto = new FollowedCountryDto();
        return ResponseEntity.ok(usuarioService.followcountry(toFollow));
    }


}
