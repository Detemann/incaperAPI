package com.sarrussys.incaperAPI.controllers;

import com.sarrussys.incaperAPI.domain.test.RequestTest;
import com.sarrussys.incaperAPI.domain.test.Test;
import com.sarrussys.incaperAPI.domain.test.TestRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping
    public ResponseEntity getAllSamples() {
        List<Test> samples = testRepository.findAll();
        return ResponseEntity.ok(samples);
    }

    @PostMapping
    public ResponseEntity registerSample(@RequestBody @Valid RequestTest data) {
        Test newSample = new Test(data);
        testRepository.save(newSample);
        return ResponseEntity.ok().build();
    }
}
