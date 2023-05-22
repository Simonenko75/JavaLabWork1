package com.example.LabWork1.model;

import com.example.LabWork1.repository.DocumentEntityRepository;
import com.example.LabWork1.service.dto.DocumentEntityDTO;
import org.springframework.stereotype.Component;

@Component
public class DocumentMappingDTOtoEntity {

    public DocumentEntityRepository documentEntityRepository;

    public DocumentEntity dtoToEntity(DocumentEntityDTO documentEntityDTO){
        if (documentEntityDTO == null) {
            return null;
        } else {
            DocumentEntity documentEntity = new DocumentEntity();
            documentEntity.setDocumentName(documentEntityDTO.getDocumentName());
            documentEntity.setLogin(documentEntityDTO.getLogin());
            documentEntity.setDocumentType(documentEntityDTO.getDocumentType());
            documentEntity.setMainText(documentEntityDTO.getMainText());
            documentEntity.setCreatedDoc(documentEntityDTO.getCreatedDoc());
            documentEntity.setSignedDoc(documentEntityDTO.getSignedDoc());
            return documentEntity;
        }
    }

    public DocumentEntityDTO entityToResponseDTO(DocumentEntity documentEntity){
        if (documentEntity == null) {
            return null;
        } else {
            DocumentEntityDTO documentEntityResponseDTO = new DocumentEntityDTO();
            documentEntityResponseDTO.setId(documentEntity.getId());
            documentEntityResponseDTO.setDocumentName(documentEntity.getDocumentName());
            documentEntityResponseDTO.setLogin(documentEntity.getLogin());
            documentEntityResponseDTO.setDocumentType(documentEntity.getDocumentType());
            documentEntityResponseDTO.setMainText(documentEntity.getMainText());
            documentEntityResponseDTO.setCreatedDoc(documentEntity.getCreatedDoc());
            documentEntityResponseDTO.setSignedDoc(documentEntity.getSignedDoc());
            return documentEntityResponseDTO;
        }
    }

    public void update(DocumentEntity documentEntity, DocumentEntityDTO documentEntityDTO) {
        if (documentEntityDTO != null) {
            documentEntity.setDocumentName(documentEntityDTO.getDocumentName());
            documentEntity.setLogin(documentEntityDTO.getLogin());
            documentEntity.setDocumentType(documentEntityDTO.getDocumentType());
            documentEntity.setMainText(documentEntityDTO.getMainText());
            documentEntity.setCreatedDoc(documentEntityDTO.getCreatedDoc());
            documentEntity.setSignedDoc(documentEntityDTO.getSignedDoc());
        }
    }

}
