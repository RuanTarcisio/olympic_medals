package com.rtarcisio.usersandnotify.domain;

import com.rtarcisio.usersandnotify.domain.enums.StatusUsuarioEnum;
import com.rtarcisio.usersandnotify.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String password;

    private String cpf;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioEnum statusUsuario;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    //private List<Paises> paisesSeguidos;


    public Usuario(String nome, String email, String password, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.role = UserRole.USER;
        this.statusUsuario = StatusUsuarioEnum.ATIVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


}