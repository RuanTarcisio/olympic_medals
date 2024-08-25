package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.repositories.CountryRepository;
import com.rtarcisio.olympic.repositories.MedalBronzeRepository;
import com.rtarcisio.olympic.repositories.MedalGoldRepository;
    import com.rtarcisio.olympic.repositories.MedalSilverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedalService {

    private final MedalGoldRepository medalGoldRepository;
    private final MedalBronzeRepository medalBronzeRepository;
    private final MedalSilverRepository medalSilverRepository;

    private final CountryService countryService;

    private final SportService sportService;
    private final CountryRepository countryRepository;






//    public Page<Medal> getAllMedals(Pageable pageable) {
//
//        return medalRepository.findAll(pageable);
//    }
//
//    public Medal getMedalById(Long id) {
//
//        return medalRepository.findById(id).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
//    }
//
//    public Medal getAllMedalsByType(String name) {
//        return medalRepository.findAllByType(name).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
//    }
//
//    public Medal getAllMedalsByCountry(String name) {
//        Country country = countryService.getCountryByName(name);
//        return medalRepository.findAllByCountry(country).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
//    }
//
//    public Medal getAllMedalsBySport(String name) {
//        Sport sport = sportService.getSportByName(name);
//        return medalRepository.findAllBySport(sport).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
//    }
//
////    public List<Medal> getAllMedalsOrderByCountry() {
////
////        List<Medal> medalhas = new ArrayList<>();
////        medalhas = medalRepository.findAll();
//////        medalhas.stream().map(m -> )
////
////        return null;
////    }
//
//    private List<Medal> orderMedals(){
//        return null;
//    }
//
//    public List<Medal> getAllMedalsOrderByCountry() {
////        return medalRepository.findAllOrderByCountry();
//        List<Medal> medals = medalRepository.findAll();
//        List<Medal> sortedMedals = medals.stream()
//                .sorted(Comparator.comparing(m -> {
//                    switch (m.getType()) {
//                        case GOLD:
//                            return 1;
//                        case SILVER:
//                            return 2;
//                        case BRONZE:
//                            return 3;
//                        default:
//                            return Integer.MAX_VALUE; // Para lidar com tipos desconhecidos
//                    }
//                }))
//                .collect(Collectors.toList());
////        medals.sort(Comparator.comparing(m -> m.getCountry().getName()));
//        return sortedMedals;
//    }
//
//
//
//    public Map<String, List<Medal>>  orderByType() {
//        // Separar as medalhas por tipo usando um mapa
//        Map<String, List<Medal>> medalsByType = new HashMap<>();
//        List<Medal> gold = medalRepository.findAllByType(MedalType.GOLD);
//        List<Medal> silver = medalRepository.findAllByType(MedalType.SILVER);
//        List<Medal> bronze = medalRepository.findAllByType(MedalType.BRONZE);
//
//        medalsByType.put("gold", gold);
//        medalsByType.put("silver", silver);
//        medalsByType.put("bronze", bronze);
//
//        //        // Lista para armazenar as listas ordenadas de medalhas
////        List<List<Medal>> medalsByTypeList = new ArrayList<>();
////
////        // Ordenar e adicionar medalhas por tipo
////        for (String type : List.of("GOLD", "SILVER", "BRONZE")) {
////            List<Medal> sortedMedals = medalsByType.getOrDefault(type, new ArrayList<>())
////                    .stream()
////                    .sorted(Comparator.comparing(Medal::getCountry)) // Ordenar por país
////                    .collect(Collectors.toList());
////            medalsByTypeList.add(sortedMedals);
////        }
//
//        allMedalsCountry(medalsByType);
//
//        return medalsByType;
//    }
//
//    private List<PaisMedalDto> allMedalsCountry(Map<String, List<Medal>> medals){
//
//        int qtd = 0;
//        List<Country> countrys = countryRepository.findAll();
//
//        List<Medal> gold = medalRepository.findAllByType(MedalType.GOLD);
//        List<Medal> silver = medalRepository.findAllByType(MedalType.SILVER);
//        List<Medal> bronze = medalRepository.findAllByType(MedalType.BRONZE);
//
//       for(Medal medal : gold){
//           for(Country country : countrys){
//               if(medal.getCountry().equals(country)){
//
//               }
//           }
//       }
//
//        return null;
//    }
}
