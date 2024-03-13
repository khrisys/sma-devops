package fr.cdrochon.thymeleaffrontend;

import fr.cdrochon.thymeleaffrontend.entity.AdresseGarage;
import fr.cdrochon.thymeleaffrontend.entity.Garage;
import fr.cdrochon.thymeleaffrontend.repository.GarageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ThymeleafFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafFrontendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(GarageRepository garageRepository) {
        return args -> {


            AdresseGarage adresse1 = AdresseGarage.builder()
                    .rue("rue du truc")
                    .numeroDeRue("17")
                    .cp("33300")
                    .ville("St Jean")
                    .build();
            AdresseGarage adresse2 = AdresseGarage.builder().rue("avenue du jo").cp("59140").numeroDeRue("51").ville(
                    "Cloerwak").build();

            List<Garage> customerList = List.of(


                    Garage.builder()
                            .nomGarage("Garage du Cres")
                            .emailContactGarage("garageDuCres@gmail.com")
                            .adresseGarage(adresse1)
                            .build(),
                    Garage.builder()
                            .nomGarage("Garage du louga")
                            .emailContactGarage("garageLouge@toto.net")
                            .adresseGarage(adresse2)
                            .build()

            );
            garageRepository.saveAll(customerList);
        };
    }


}
