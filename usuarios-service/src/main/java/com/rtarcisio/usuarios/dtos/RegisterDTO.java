package com.rtarcisio.usuarios.dtos;

import com.rtarcisio.usuarios.domain.Role;
import com.rtarcisio.usuarios.domain.enums.UserRole;

import java.time.LocalDate;

public record RegisterDTO(String email, String password, String nome, String cpf, LocalDate dataNascimento) {
}
