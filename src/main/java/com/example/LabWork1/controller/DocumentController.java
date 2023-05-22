package com.example.LabWork1.controller;

import com.example.LabWork1.model.DocumentEntity;
import com.example.LabWork1.service.DocumentService;
import com.example.LabWork1.service.dto.DocumentEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/create")
    public @ResponseBody DocumentEntityDTO insertTestEntity(@RequestBody DocumentEntityDTO documentEntityDTO){
        return documentService.insertDocumentEntity(documentEntityDTO);
    }

    @GetMapping("/login")
    public @ResponseBody List<DocumentEntityDTO> findByLogin(@RequestParam String login){
        return documentService.findByLogin(login);
    }

    @GetMapping("/login/signed")
    public @ResponseBody List<DocumentEntityDTO> findAllByLoginAndSigned(@RequestParam String login){
        return documentService.getAllByLoginAndSigned(login);
    }

    @GetMapping("/login/not-signed")
    public @ResponseBody List<DocumentEntityDTO> findAllByLoginAndNotSigned(@RequestParam String login){
        return documentService.getAllByLoginAndNotSigned(login);
    }

    @GetMapping("/date-range")
    public @ResponseBody List<DocumentEntityDTO> findAllByDateRange(@RequestParam("from") Long from, @RequestParam("to") Long to){
        return documentService.getAllByDateRange(Instant.ofEpochMilli(from), Instant.ofEpochMilli(to));
    }

    @PutMapping("/{id}")
    public DocumentEntity update(@RequestParam("id") Long id, @RequestBody DocumentEntityDTO documentEntityDTO) {
        DocumentEntity documentEntity = documentService.findById(id);
        documentService.update(documentEntity, documentEntityDTO);
        documentService.save(documentEntity);
        return documentEntity;
    }

    @DeleteMapping("/id")
    public void delete(@RequestParam("id") Long documentId) {
        documentService.deleteById(documentId);
    }

}
