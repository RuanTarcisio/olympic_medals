package com.rtarcisio.usersandnotify.controller;

import com.rtarcisio.usersandnotify.domain.Country;
import com.rtarcisio.usersandnotify.domain.Usuario;
import com.rtarcisio.usersandnotify.dtos.UsuarioCountriesDto;
import com.rtarcisio.usersandnotify.security.TokenService;
import com.rtarcisio.usersandnotify.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
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
    public String statusApi() {
        return "OK";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/follow-country")
    private ResponseEntity<UsuarioCountriesDto> followedCountry(@RequestBody List<Country> toFollow  /*@RequestBody FollowedCountryDto dto*/) {

        return ResponseEntity.ok(usuarioService.followcountry(toFollow));
    }

    @GetMapping(value = "/code")
    public ResponseEntity<List<Usuario>> seguemCountry(@RequestParam String countryCode) {


        return ResponseEntity.ok(service.queSeguemPais(countryCode));

    }
}
