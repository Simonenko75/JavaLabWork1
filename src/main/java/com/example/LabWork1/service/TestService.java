package com.example.LabWork1.service;

import com.example.LabWork1.model.TestEntity;
import com.example.LabWork1.repository.TestEntityRepository;
import com.example.LabWork1.service.dto.TestEntityDTO;
import com.example.LabWork1.service.dto.TestRequestDTO;
import com.example.LabWork1.service.dto.TestResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestService {

    public TestResponseDTO executeTestGet(){

        //Logger logger = LoggerFactory.getLogger(TestService.class);

        log.info("get executed {} {}", 12, 12);
        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setResponseText("Hello from get!!!");
        return testResponseDTO;
    }

    public TestResponseDTO executeTestPost(TestRequestDTO testRequestDTO){
        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setResponseText("Hello from post!!!" + testRequestDTO.getTextData() + " " + testRequestDTO.getNumericData());
        return testResponseDTO;
    }

    public TestResponseDTO executeTestPut(TestRequestDTO testRequestDTO){
        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setResponseText("Hello from put!!!" + testRequestDTO.getTextData() + " " + testRequestDTO.getNumericData());
        return testResponseDTO;
    }

    public TestResponseDTO executeTestDelete(TestRequestDTO testRequestDTO){
        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setResponseText("Hello from delete!!!" + testRequestDTO.getTextData() + " " + testRequestDTO.getNumericData());
        return testResponseDTO;
    }

    @Autowired
    public TestEntityRepository testEntityRepository;

    public TestEntityDTO insertTestEntity(TestEntityDTO testEntityDTO){
        TestEntity testEntity = new TestEntity();
        testEntity.setName(testEntityDTO.getName());
        testEntity.setAge(testEntityDTO.getAge());
        testEntityRepository.save(testEntity);

        TestEntityDTO testEntityResponseDTO = new TestEntityDTO();
        testEntityResponseDTO.setId(testEntity.getId());
        testEntityResponseDTO.setName(testEntity.getName());
        testEntityResponseDTO.setAge(testEntity.getAge());
        return testEntityResponseDTO;
    }

    public List<TestEntityDTO> findByAge(int age){
        List<TestEntityDTO> resultList = new ArrayList<>();
        testEntityRepository.findByAgeGreaterThan(age).forEach(
                testEntity -> {
                    TestEntityDTO testEntityDTO = new TestEntityDTO();
                    testEntityDTO.setName(testEntity.getName());
                    testEntityDTO.setAge(testEntity.getAge());
                    testEntityDTO.setId(testEntity.getId());
                    resultList.add(testEntityDTO);
                }
        );

        return resultList;
    }

}
