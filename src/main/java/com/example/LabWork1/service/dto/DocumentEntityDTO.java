package com.example.LabWork1.service.dto;

import com.example.LabWork1.model.DocumentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class DocumentEntityDTO {

    private Long id;

    private String documentName;

    private String login;

    private DocumentType documentType;

    private String mainText;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant createdDoc;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant signedDoc;

}
