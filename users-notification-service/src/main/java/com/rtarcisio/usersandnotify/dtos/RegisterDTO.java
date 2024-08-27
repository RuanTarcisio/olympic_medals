package com.rtarcisio.usersandnotify.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterDTO(@Email String email, @NotNull String password, @NotNull String nome, @NotNull String cpf, @NotNull LocalDate dataNascimento) {
}
