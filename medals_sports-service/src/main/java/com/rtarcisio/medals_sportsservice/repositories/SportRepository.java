package com.rtarcisio.medals_sportsservice.repositories;

import com.rtarcisio.medals_sportsservice.domain.Medal;
import com.rtarcisio.medals_sportsservice.domain.Sport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {

//    Page<Sport> findAll(String countryName, Pageable pageable);

}
