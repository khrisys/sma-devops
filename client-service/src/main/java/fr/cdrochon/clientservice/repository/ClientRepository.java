package fr.cdrochon.clientservice.repository;

import fr.cdrochon.clientservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
