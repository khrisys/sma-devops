package fr.cdrochon.vehiculeservice.entity;

import fr.cdrochon.vehiculeservice.model.Client;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //FIXME : GOD CLASS
    private String immatriculationVehicule;
    private LocalDate dateMiseEnCirculationVehicule;
//    private LocalDate dateDeValiditeControleTechnique;
//    private LocalDate dateValiditeControleTechniqueComplementaire;
//    private String urlCertificatImmatriculation;
//    private String modeleVehicule;
//    private MotorisationVehicule motorisationVehicule;
//    private String finitionMotorisationVehicule;
//    private TypeCarburant typeCarburant;
//    private TypePropulsion typePropulsion;
    private TypeVehicule typeVehicule;
    private MarqueVehicule marqueVehicule;
//    private TypeFreinage typeFreinage;
//    private TypeSuspension typeSuspension;
    private boolean climatisationVehicule;
    
    // communication inter ms
    @Transient
    private Client client;
    private Long clientId;
}
