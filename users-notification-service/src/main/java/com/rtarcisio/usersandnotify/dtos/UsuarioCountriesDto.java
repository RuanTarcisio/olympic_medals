package com.rtarcisio.usersandnotify.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCountriesDto {

    private Long id;
    private String nome;
    private String email;
    private List<Long> followedCountryIds = new ArrayList<>();
}
