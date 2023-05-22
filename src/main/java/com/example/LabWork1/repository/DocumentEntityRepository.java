package com.example.LabWork1.repository;

import com.example.LabWork1.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface DocumentEntityRepository extends JpaRepository<DocumentEntity, Long> {

    List<DocumentEntity> findAllByLogin(String login);

    List<DocumentEntity> findAllByLoginAndSignedDocIsNull(String login);

    List<DocumentEntity> findAllByLoginAndSignedDocIsNotNull(String login);

    List<DocumentEntity> findAllByCreatedDocBetween(Instant from, Instant to);

}
