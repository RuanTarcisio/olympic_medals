package com.rtarcisio.usuarios.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    //    public Role(RoleDto roleDto) {
//        this.id = roleDto.id();
//        this.role = roleDto.role();
//    }
//
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return null;
    }
}
