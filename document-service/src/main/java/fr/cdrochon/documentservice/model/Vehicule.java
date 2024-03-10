package fr.cdrochon.documentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
public class Vehicule {

    private Long id;
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
}
