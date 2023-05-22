package com.example.LabWork1.service;

import com.example.LabWork1.model.DocumentEntity;
import com.example.LabWork1.model.DocumentMappingDTOtoEntity;
import com.example.LabWork1.repository.DocumentEntityRepository;
import com.example.LabWork1.service.dto.DocumentEntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DocumentService {

    @Autowired
    public DocumentEntityRepository documentEntityRepository;

    @Autowired
    public DocumentMappingDTOtoEntity documentMappingDTOtoEntity;

    public DocumentEntity save(DocumentEntity documentEntity) {
        return documentEntityRepository.save(documentEntity);
    }

    public DocumentEntityDTO insertDocumentEntity(DocumentEntityDTO documentEntityDTO){
        return documentMappingDTOtoEntity.entityToResponseDTO(save(documentMappingDTOtoEntity.dtoToEntity(documentEntityDTO)));
    }

    public void update(DocumentEntity documentEntity, DocumentEntityDTO documentEntityDTO) {
        documentMappingDTOtoEntity.update(documentEntity, documentEntityDTO);
    }

    public DocumentEntity findById(long id) {
        return documentEntityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Document not found"));
    }

    public List<DocumentEntityDTO> findByLogin(String login) {
        List<DocumentEntityDTO> resultList = new ArrayList<>();
        documentEntityRepository.findAllByLogin(login).forEach(
                documentEntity -> {
                    resultList.add(documentMappingDTOtoEntity.entityToResponseDTO(documentEntity));
                    //log.info("get executed {} {}", documentMappingDTOtoEntity.entityToResponseDTO(documentEntity), resultList);
                }
        );

        return resultList;
    }

    public List<DocumentEntityDTO> getAllByLoginAndSigned(String login) {
        List<DocumentEntityDTO> resultList = new ArrayList<>();
        documentEntityRepository.findAllByLoginAndSignedDocIsNotNull(login).forEach(
                documentEntity -> {
                    resultList.add(documentMappingDTOtoEntity.entityToResponseDTO(documentEntity));
                }
        );

        return resultList;
    }

    public List<DocumentEntityDTO> getAllByLoginAndNotSigned(String login) {
        List<DocumentEntityDTO> resultList = new ArrayList<>();
        documentEntityRepository.findAllByLoginAndSignedDocIsNull(login).forEach(
                documentEntity -> {
                    resultList.add(documentMappingDTOtoEntity.entityToResponseDTO(documentEntity));
                }
        );

        return resultList;
    }

    public List<DocumentEntityDTO> getAllByDateRange(Instant from, Instant to) {
        List<DocumentEntityDTO> resultList = new ArrayList<>();
        documentEntityRepository.findAllByCreatedDocBetween(from, to).forEach(
                documentEntity -> {
                    resultList.add(documentMappingDTOtoEntity.entityToResponseDTO(documentEntity));
                }
        );

        return resultList;
    }

    public void deleteById(long id) {
        documentEntityRepository.deleteById(id);
    }

}
