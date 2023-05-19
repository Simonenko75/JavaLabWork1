package com.example.LabWork1.model;

import lombok.Getter;
import lombok.Setter;

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
    private String document_name;

    @Column
    private String login;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentType document_type;

    @Column
    private String main_text;

    @Column
    private Instant created_doc;

    @Column
    private Instant signed_doc;

}
