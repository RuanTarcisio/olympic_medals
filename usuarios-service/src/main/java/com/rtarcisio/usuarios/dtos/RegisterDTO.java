package com.rtarcisio.usuarios.dtos;

import com.rtarcisio.usuarios.domain.Role;
import com.rtarcisio.usuarios.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
