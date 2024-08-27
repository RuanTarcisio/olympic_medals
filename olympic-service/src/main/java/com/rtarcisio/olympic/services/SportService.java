package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.repositories.SportRepository;
import com.rtarcisio.olympic.services.exceptions.UsuarioNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository sportRepository;

    public Page<Sport> getAllSports(Pageable pageable) {

        return sportRepository.findAll(pageable);
    }

    public Sport getSportById(Long id) {

        return sportRepository.findById(id).orElseThrow(() ->new UsuarioNaoEncontradoException("Sport não cadastrado."));
    }

    public Sport getSportByName(String name) {
        return sportRepository.findByNameSport(name).orElseThrow(() ->new UsuarioNaoEncontradoException("Sport não cadastrado."));
    }
}
