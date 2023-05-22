package com.example.LabWork1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "document_table")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String documentName;

    @Column
    private String login;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column
    private String mainText;

    @Column
    private Instant createdDoc;

    @Column
    private Instant signedDoc;

}
