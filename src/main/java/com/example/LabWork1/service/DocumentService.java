package com.example.LabWork1.service;

import com.example.LabWork1.repository.DocumentEntityRepository;
import com.example.LabWork1.repository.TestEntityRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    public DocumentEntityRepository documentEntityRepository;



}
