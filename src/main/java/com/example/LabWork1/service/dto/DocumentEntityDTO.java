package com.example.LabWork1.service.dto;

import com.example.LabWork1.model.DocumentType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class DocumentEntityDTO {

    private Long id;

    private String document_name;

    private String login;

    private DocumentType document_type;

    private String main_text;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant created_doc;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant signed_doc;

}
