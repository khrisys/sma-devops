package fr.cdrochon.clientservice.controller;

import fr.cdrochon.clientservice.repository.ClientRepository;
import fr.cdrochon.clientservice.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestController {
    
    private ClientRepository clientRepository;
    
    public ClientRestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                               .get();
    }
    
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
