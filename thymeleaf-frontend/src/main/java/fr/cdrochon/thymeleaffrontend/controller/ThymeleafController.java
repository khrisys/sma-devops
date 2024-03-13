package fr.cdrochon.thymeleaffrontend.controller;

import fr.cdrochon.thymeleaffrontend.entity.Client;
import fr.cdrochon.thymeleaffrontend.entity.Garage;
import fr.cdrochon.thymeleaffrontend.repository.ClientRepository;
import fr.cdrochon.thymeleaffrontend.repository.GarageRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    private GarageRepository garageRepository;
    private ClientRepository clientRepository;
    private ClientRegistrationRepository clientRegistrationRepository;

    public ThymeleafController(GarageRepository garageRepository, ClientRepository clientRepository, ClientRegistrationRepository clientRegistrationRepository) {
        this.garageRepository = garageRepository;
        this.clientRepository = clientRepository;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

//    @GetMapping("/garage/{id}")
//    public String garageById(@PathVariable Long id){
//        return garageRepository.findById(id).get();
//    }

    @GetMapping("/garages")
    //@PreAuthorize("hasAuthority('USER')")
    public String garages(Model model) {
        List<Garage> garages = garageRepository.findAll();
        model.addAttribute("garages", garages);
        return "garages";
    }

    @GetMapping("/clients")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String clients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    /**
     * Path qui permet de recuperer les informations sur la session courante et les users authentifiés
     *
     * @param authentication authentication
     * @return objet authentication au format json grace à @ResponseBody
     */
    @GetMapping("/auth")
    @ResponseBody
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }

    /**
     * Par defaut, l'appli s'ouvre sans path. Lorsque c'est le cas, on renseigne le path à une page index.html
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Renvoi l'user vers la page notAuthorized.html lorsqu'il tente de se rendre sur une url du site dont il n'a pas les droits
     *
     * @return page notAuthorized.html
     */
    @GetMapping("/notAutorized")
    public String notAutorized() {
        return "notAuthorized";
    }

    @GetMapping("/oauth2Login")
    public String oauth2Login(Model model) {
        String authorizationRequestBaseUri = "oauth2/authorization";
        Map<String, String> oauth2AuthenticationUrls = new HashMap();
        Iterable<ClientRegistration> clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        ;
        clientRegistrations.forEach(registration -> {
            oauth2AuthenticationUrls.put(registration.getClientName(),
                    authorizationRequestBaseUri + "/" + registration.getRegistrationId());
        });
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "oauth2Login";
    }
}
