package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.MedalGold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MedalGoldRepository extends JpaRepository<MedalGold, Long> {

List<MedalGold> findAllByCountry(Country country);

//    @Query("SELECT m FROM Medal m JOIN m.country c ORDER BY c.countryId, m.awardDate")
//    List<Medal> findAllMedalsOrderedByCountry();

}
