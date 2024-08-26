package com.rtarcisio.olympic.services.utils;


import com.rtarcisio.olympic.dtos.UsuarioDto;
import com.rtarcisio.olympic.security.CustomUserDetails;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class UsuarioUtils {

    public static UsuarioDto getUsuarioLogado(){
        CustomUserDetails user =  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new UsuarioDto(user.getUsername(), user.getPassword());
    }
}
