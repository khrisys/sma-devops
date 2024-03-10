package fr.cdrochon.garageservice.repository;

import fr.cdrochon.garageservice.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<Garage, Long> {
}
