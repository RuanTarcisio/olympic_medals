package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Medal;
import com.rtarcisio.olympic.domain.Sport;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MedalRepository extends PagingAndSortingRepository<Medal, Long> {

    Optional<Medal> findById(Long id);

//    Optional<Medal> findByType(String type);
//
//    Optional<Medal> findByCountry(String country);
//
//    Optional<Medal> findBySport(String sport);

    Optional<Medal> findAllByType(String type);

    Optional<Medal> findAllByCountry(Country country);

    Optional<Medal> findAllBySport(Sport sport);

}
