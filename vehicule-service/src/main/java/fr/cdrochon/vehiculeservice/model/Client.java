package fr.cdrochon.vehiculeservice.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
public class Client {
    
    private Long id;
    
    private String nomClient;
    private String prenomClient;
    private String mailClient;
    private String telClient;
    private AdresseClient adresseClient;
}
