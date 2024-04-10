package fr.cdrochon.clientservice;

import fr.cdrochon.clientservice.config.GetClientParamsConfig;
import fr.cdrochon.clientservice.config.GetParamsGlobalConfig;
import fr.cdrochon.clientservice.entity.AdresseClient;
import fr.cdrochon.clientservice.entity.Client;
import fr.cdrochon.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@EntityScan("fr.cdrochon.clientservice.entity")
@EnableConfigurationProperties({GetClientParamsConfig.class, GetParamsGlobalConfig.class})
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {

            AdresseClient adresse1 = AdresseClient.builder()
                    .rue("rue du truc")
                    .numeroDeRue("17")
                    .cp("33300")
                    .ville("St Jean")
                    .build();
            AdresseClient adresse2 = AdresseClient.builder()
                    .rue("avenue du jo")
                    .cp("59140")
                    .numeroDeRue("51")
                    .ville("Cloerwak")
                    .build();

            List<Client> customerList = List.of(


                    Client.builder()
                            .id(1L)
                            .nomClient("Dubourg")
                            .prenomClient("Jean")
                            .mailClient("jean.dubourg@gmail.com")
                            .telClient("0123456789")
                            .adresseClient(adresse1)
                            .build(),
                    Client.builder()
                            .id(2L)
                            .nomClient("Berga")
                            .prenomClient("Christine")
                            .mailClient("chirstine.berga@tut.io")
                            .telClient("9876541320")
                            .adresseClient(adresse2)
                            .build(),
                    Client.builder()
                            .id(3L)
                            .nomClient("Poloua")
                            .prenomClient("Gerard")
                            .mailClient("gegelembrouille@tut.io")
                            .telClient("8888888888")
                            .adresseClient(adresse2)
                            .build()

            );
            clientRepository.saveAll(customerList);
        };
    }

}
