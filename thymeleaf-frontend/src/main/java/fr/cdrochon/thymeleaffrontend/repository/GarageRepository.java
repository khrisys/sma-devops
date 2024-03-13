package fr.cdrochon.thymeleaffrontend.repository;

import fr.cdrochon.thymeleaffrontend.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<Garage, Long> {
}
