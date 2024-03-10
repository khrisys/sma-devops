package fr.cdrochon.documentservice.controller;

import fr.cdrochon.documentservice.entity.Document;
import fr.cdrochon.documentservice.model.Vehicule;
import fr.cdrochon.documentservice.repository.DocumentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentRestController {
    
    private final DocumentRepository documentRepository;
    private final VehiculeRestFeign vehiculeRestFeign;
    
    public DocumentRestController(DocumentRepository documentRepository,
                                  VehiculeRestFeign vehiculeRestFeign) {
        this.documentRepository = documentRepository;
        this.vehiculeRestFeign = vehiculeRestFeign;
    }
    
    /**
     * Retourne les informations d'un document accompagné des informations du vehicule qu'il concerne
     *
     * @param id id de document
     * @return document
     */
    @GetMapping("/document/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        Document document = documentRepository.findById(id).get();
        
        Vehicule vehicule = vehiculeRestFeign.findVehiculeById(document.getId());
        document.setVehicule(vehicule);
        return document;
    }
    
    /**
     * Retourne tous les documents concernant un vehicule
     *
     * @return liste de documents
     */
    @GetMapping("/documents")
    public List<Document> getDocuments() {
        List<Document> documents = documentRepository.findAll();
        
        documents.forEach(doc -> {
            doc.setVehicule(vehiculeRestFeign.findVehiculeById(doc.getVehiculeId()));
        });
        return documents;
    }
}
