package fr.cdrochon.vehiculeservice.controller;

import fr.cdrochon.vehiculeservice.entity.Vehicule;
import fr.cdrochon.vehiculeservice.model.Client;
import fr.cdrochon.vehiculeservice.repository.VehiculeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculeRestController {
    
    private final VehiculeRepository vehiculeRepository;
    private final ClientRestFeign clientRestFeign;
    
    public VehiculeRestController(VehiculeRepository vehiculeRepository, ClientRestFeign clientRestFeign) {
        this.vehiculeRepository = vehiculeRepository;
        this.clientRestFeign = clientRestFeign;
    }
    
    @GetMapping("/vehicule/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        
        Client client = clientRestFeign.findClientById(vehicule.getId());
        vehicule.setClient(client);
        return vehicule;
    }
    
    @GetMapping("/vehicules")
    public List<Vehicule> getVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        
        vehicules.forEach(c -> {
            c.setClient(clientRestFeign.findClientById(c.getClientId()));
        });
        return vehicules;
    }
}
