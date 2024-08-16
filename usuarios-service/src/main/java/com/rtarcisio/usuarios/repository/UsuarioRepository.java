package com.rtarcisio.usuarios.repository;

import com.rtarcisio.usuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String login);

    Optional<Usuario> findByCpf(String cpf);
}
