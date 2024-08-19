package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.Sport;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface SportRepository extends PagingAndSortingRepository<Sport, Long> {

//    List<Sport> findAllAndOrderByAsc(Pageable pageable);

//    Page<Sport> findAllAndOrderAsc(Pageable pageable);

    Optional<Sport> findByNameSport(String name);

    Optional<Sport> findById(Long id);
}
