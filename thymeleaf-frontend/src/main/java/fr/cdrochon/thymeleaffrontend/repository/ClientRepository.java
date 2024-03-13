package fr.cdrochon.thymeleaffrontend.repository;


import fr.cdrochon.thymeleaffrontend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
