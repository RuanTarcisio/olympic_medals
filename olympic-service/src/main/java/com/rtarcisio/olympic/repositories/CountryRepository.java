package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    Optional<Country> findByCode(String code);

    List<Country> findAll();
}
