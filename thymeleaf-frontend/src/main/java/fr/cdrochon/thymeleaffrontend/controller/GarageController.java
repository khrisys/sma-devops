package fr.cdrochon.thymeleaffrontend.controller;

import fr.cdrochon.thymeleaffrontend.entity.Garage;
import fr.cdrochon.thymeleaffrontend.repository.GarageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GarageController {
    private final GarageRepository garageRepository;

    public GarageController(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

//    @GetMapping("/garage/{id}")
//    public String garageById(@PathVariable Long id){
//        return garageRepository.findById(id).get();
//    }

    @GetMapping("/garages")
    public String garages(Model model){
        List<Garage> garages = garageRepository.findAll();
        model.addAttribute("garages", garages);
        return "garages";
    }
}
