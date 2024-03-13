package fr.cdrochon.thymeleaffrontend;

import fr.cdrochon.thymeleaffrontend.entity.Adresse;
import fr.cdrochon.thymeleaffrontend.entity.Client;
import fr.cdrochon.thymeleaffrontend.entity.Garage;
import fr.cdrochon.thymeleaffrontend.repository.ClientRepository;
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
    CommandLineRunner commandLineRunner(GarageRepository garageRepository, ClientRepository clientRepository) {
        return args -> {


            Adresse adresse1 = Adresse.builder()
                    .rue("rue du truc")
                    .numeroDeRue("17")
                    .cp("33300")
                    .ville("St Jean")
                    .build();
            Adresse adresse2 = Adresse.builder().rue("avenue du jo").cp("59140").numeroDeRue("51").ville(
                    "Cloerwak").build();

            List<Garage> garageList = List.of(


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
            garageRepository.saveAll(garageList);

            List<Client> clientList = List.of(


                    Client.builder()
                            .nomClient("Dubourg")
                            .prenomClient("Jean")
                            .mailClient("jean.dubourg@gmail.com")
                            .telClient("0123456789")
                            .adresseClient(adresse1)
                            .build(),
                    Client.builder()
                            .nomClient("Berga")
                            .prenomClient("Christine")
                            .mailClient("chirstine.berga@tut.io")
                            .telClient("9876541320")
                            .adresseClient(adresse2)
                            .build(),
                    Client.builder()
                            .nomClient("Poloua")
                            .prenomClient("Gerard")
                            .mailClient("gegelembrouille@tut.io")
                            .telClient("8888888888")
                            .adresseClient(adresse2)
                            .build()
            );
            clientRepository.saveAll(clientList);
        };
    }


}
