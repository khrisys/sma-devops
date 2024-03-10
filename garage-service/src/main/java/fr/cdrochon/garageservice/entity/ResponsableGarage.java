package fr.cdrochon.garageservice.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ResponsableGarage {
    private String nomDuResponsable;
    private String prenomDuResponsable;
    private String mailDuResponsable;
    private String telDuResponsable;
}
