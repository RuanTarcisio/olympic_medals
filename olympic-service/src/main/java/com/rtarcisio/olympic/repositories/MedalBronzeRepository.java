package com.rtarcisio.olympic.repositories;

import com.rtarcisio.olympic.domain.MedalGold;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedalBronzeRepository extends PagingAndSortingRepository<MedalGold, Long> {



//    @Query("SELECT m FROM Medal m JOIN m.country c ORDER BY c.countryId, m.awardDate")
//    List<Medal> findAllMedalsOrderedByCountry();

}
