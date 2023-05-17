package com.example.LabWork1.controller;

import com.example.LabWork1.service.TestService;
import com.example.LabWork1.service.dto.TestEntityDTO;
import com.example.LabWork1.service.dto.TestRequestDTO;
import com.example.LabWork1.service.dto.TestResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    //@Autowired
    ///private TestResponseDTO testResponseDTO;

    @GetMapping("/execute")
    public @ResponseBody TestResponseDTO executeTestGet(){
        return testService.executeTestGet();
    }

    @PostMapping("/execute")
    public @ResponseBody TestResponseDTO executeTestPost(@RequestBody TestRequestDTO testRequestDTO){
        return testService.executeTestPost(testRequestDTO);
    }

    @PutMapping("/execute")
    public @ResponseBody TestResponseDTO executeTestPut(@RequestBody TestRequestDTO testRequestDTO){
        return testService.executeTestPut(testRequestDTO);
    }

    @DeleteMapping("/delete")
    public @ResponseBody TestResponseDTO executeTestDelete(@RequestBody TestRequestDTO testRequestDTO){
        return testService.executeTestDelete(testRequestDTO);
    }

    @PostMapping("/entity")
    public @ResponseBody TestEntityDTO insertTestEntity(@RequestBody TestEntityDTO testEntityDTO){
        return testService.insertTestEntity(testEntityDTO);
    }

    @GetMapping("/entity")
    public @ResponseBody List<TestEntityDTO> findByAge(@RequestParam int age){
        return testService.findByAge(age);
    }

}
