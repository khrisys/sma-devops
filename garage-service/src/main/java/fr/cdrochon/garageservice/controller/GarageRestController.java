package fr.cdrochon.garageservice.controller;

import fr.cdrochon.garageservice.entity.Garage;
import fr.cdrochon.garageservice.repository.GarageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GarageRestController {
    
    private final GarageRepository garageRepository;
    
    public GarageRestController(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }
    @GetMapping("/garage/{id}")
    public Garage garageById(@PathVariable Long id){
        return garageRepository.findById(id).get();
    }
    
    @GetMapping("/garages")
    public List<Garage> garageSet(){
        return garageRepository.findAll();
    }
}
