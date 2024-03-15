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
}
