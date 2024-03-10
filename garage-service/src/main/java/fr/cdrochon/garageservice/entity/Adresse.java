package fr.cdrochon.garageservice.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable @Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Adresse {
    
    private String numeroDeRue;
    private String rue;
    private String cp;
    private String ville;
}
