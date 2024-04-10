package fr.cdrochon.documentservice;

import fr.cdrochon.documentservice.controller.VehiculeRestFeign;
import fr.cdrochon.documentservice.entity.Document;
import fr.cdrochon.documentservice.entity.TypeDocument;
import fr.cdrochon.documentservice.repository.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class DocumentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository documentRepository,
                                        VehiculeRestFeign vehiculeRestFeign) {
        return args -> {
            //vehiculeRestFeign.findEveryVehicules().forEach(v -> {
                //FIXME : normalement, il n'y a pas de date de modif d'un doc
                Document d1 = Document.builder()
                        .nomDocument("devis-00012547")
                        .titreDocument("rdv pour essieu")
                        .emetteurDuDocument("garage durand")
                        .typeDocument(TypeDocument.DEVIS)
                        .dateCreationDocument(LocalDate.now())
                        .dateModificationDocument(LocalDate.now())
                        .vehiculeId(2L)
                        //.vehiculeId(v.getId())
                        .build();
                Document d2 = Document.builder()
                        .nomDocument("facture mr X")
                        .titreDocument("facture du garage robert")
                        .emetteurDuDocument("garage robert")
                        .typeDocument(TypeDocument.FACTURE)
                        .dateCreationDocument(LocalDate.now())
                        .dateModificationDocument(LocalDate.now())
                        .vehiculeId(1L)
                        .build();
                Document d3 = Document.builder()
                        .nomDocument("devis sans titre")
                        .emetteurDuDocument("garage toto")
                        .emetteurDuDocument("jean jean")
                        .typeDocument(TypeDocument.DEVIS)
                        .dateCreationDocument(LocalDate.now())
                        .dateModificationDocument(LocalDate.now())
                        .vehiculeId(1L)
                        .build();
                Document d4 = Document.builder()
                        .nomDocument("devis sans titre")
                        .emetteurDuDocument("garage toto")
                        .emetteurDuDocument("jean jean")
                        .typeDocument(TypeDocument.DEVIS)
                        .dateCreationDocument(LocalDate.now())
                        .dateModificationDocument(LocalDate.now())
                        .vehiculeId(3L)
                        //.vehiculeId(v.getId())
                        .build();
                documentRepository.save(d1);
                documentRepository.save(d2);
                documentRepository.save(d3);
                documentRepository.save(d4);
            //});
        };
    }
}
