package com.rtarcisio.usersandnotify.repository;

import com.rtarcisio.usersandnotify.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String login);

    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findAllByFollowedCountries_Id(Long id);

    List<Usuario> findAllByFollowedCountries_Code(String countryCode);
}
