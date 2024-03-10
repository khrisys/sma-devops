package fr.cdrochon.documentservice.repository;

import fr.cdrochon.documentservice.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
