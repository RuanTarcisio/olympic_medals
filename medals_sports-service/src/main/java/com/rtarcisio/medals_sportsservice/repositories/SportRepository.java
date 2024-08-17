package com.rtarcisio.medals_sportsservice.repositories;

import com.rtarcisio.medals_sportsservice.domain.Sport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SportRepository extends PagingAndSortingRepository<Sport, Long> {

//    List<Sport> findAllAndOrderByAsc(Pageable pageable);

//    Page<Sport> findAllAndOrderAsc(Pageable pageable);
}
