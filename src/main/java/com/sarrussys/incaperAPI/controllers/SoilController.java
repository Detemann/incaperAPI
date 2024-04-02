package com.sarrussys.incaperAPI.controllers;

import com.sarrussys.incaperAPI.domain.soil.RequestSoil;
import com.sarrussys.incaperAPI.domain.soil.Soil;
import com.sarrussys.incaperAPI.domain.soil.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amostras")
@CrossOrigin
public class SoilController {

    @Autowired
    private SoilRepository soloRepository;

    @GetMapping
    public ResponseEntity getAllAmostras() {
        List<Soil> samples = soloRepository.findAll();
        return ResponseEntity.ok(samples);
    }

    @PostMapping
    public ResponseEntity createAmostra(@RequestBody RequestSoil amostraSolo) {
        Soil newSoil = new Soil(amostraSolo);
        soloRepository.save(newSoil);
        return ResponseEntity.ok().build();
    }
}
