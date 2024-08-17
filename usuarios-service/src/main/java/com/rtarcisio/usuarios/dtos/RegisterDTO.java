package com.rtarcisio.usuarios.dtos;

import java.time.LocalDate;

public record RegisterDTO(String email, String password, String nome, String cpf, LocalDate dataNascimento) {
}
