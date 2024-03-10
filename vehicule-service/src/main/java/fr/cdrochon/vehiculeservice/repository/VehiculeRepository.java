package fr.cdrochon.vehiculeservice.repository;

import fr.cdrochon.vehiculeservice.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
