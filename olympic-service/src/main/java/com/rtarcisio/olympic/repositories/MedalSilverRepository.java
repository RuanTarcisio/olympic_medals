package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.MedalGold;
import com.rtarcisio.olympic.domain.MedalSilver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedalSilverRepository extends JpaRepository<MedalSilver, Long> {

    List<MedalSilver> findAllByCountry(Country country);

//    @Query("SELECT m FROM Medal m JOIN m.country c ORDER BY c.countryId, m.awardDate")
//    List<Medal> findAllMedalsOrderedByCountry();

}
