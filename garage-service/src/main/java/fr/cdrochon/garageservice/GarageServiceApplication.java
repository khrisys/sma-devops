package fr.cdrochon.garageservice;

import fr.cdrochon.garageservice.entity.Adresse;
import fr.cdrochon.garageservice.entity.Garage;
import fr.cdrochon.garageservice.repository.GarageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GarageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarageServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(GarageRepository garageRepository) {
        return args -> {

            Adresse adresse1 = Adresse.builder()
                    .rue("rue du truc")
                    .numeroDeRue("17")
                    .cp("33300")
                    .ville("St Jean")
                    .build();
            Adresse adresse2 = Adresse.builder().rue("avenue du jo").cp("59140").numeroDeRue("51").ville(
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
