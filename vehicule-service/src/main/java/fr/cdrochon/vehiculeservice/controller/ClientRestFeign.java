package fr.cdrochon.vehiculeservice.controller;

import fr.cdrochon.vehiculeservice.model.AdresseClient;
import fr.cdrochon.vehiculeservice.model.Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Communication inter services avec prise en charge de la tolerance aux pannes
 */
@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestFeign {
    
    @GetMapping("/client/{id}")
    @CircuitBreaker(name = "clientService", fallbackMethod = "getDefaultClient")
    Client findClientById(@PathVariable Long id);
    
    @GetMapping("/clients")
    @CircuitBreaker(name = "clientService", fallbackMethod = "getDefaultAllClients")
    List<Client> findEveryClients();
    
    /**
     * Comportement par defaut lorsque le microservice client ne repond pas.
     *
     * @param id        id du client
     * @param exception type exception
     * @return objet client vide
     */
    default Client getDefaultClient(Long id, Exception exception) {
        AdresseClient adresseClient = new AdresseClient("Numero de rue non disponible", "Rue non " +
                "disponible", "CP non disponible", "Ville non disponible");
        
        Client client = new Client();
        client.setId(id);
        client.setNomClient("Non disponible");
        client.setPrenomClient("Non disponible");
        client.setTelClient("Non disponible");
        client.setMailClient("Non disponible");
        client.setAdresseClient(adresseClient);
        System.err.println("Exception default getDefaultCustomer : " + exception.getMessage());
        return client;
    }
    
    /**
     * Retourne une liste vide de clients par defaut
     *
     * @param exception type exception
     * @return liste vide de clients
     */
    default List<Client> getDefaultAllClients(Exception exception) {
        System.err.println("Exception default getAllCustomers : " + exception.getMessage());
        
        List<Client> clients = new ArrayList<>();
        AdresseClient adresseClient = new AdresseClient("nd", "nd", "nd", "nd");
        clients.forEach(c-> {
            c.setNomClient("Nom non disponible");
            c.setPrenomClient("Prenom non disponible");
            c.setMailClient("Mail non disponible");
            c.setTelClient("Téléphone non disponible");
            c.setAdresseClient(adresseClient);
        });
        return clients;
    }
}
