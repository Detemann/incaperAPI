package com.sarrussys.incaperapi.controllers;

import com.sarrussys.incaperapi.model.soil.RequestSoil;
import com.sarrussys.incaperapi.services.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soil")
@CrossOrigin(origins = "*") // apague o comentario em caso de erro de CORS
public class SoilController {

    @Autowired
    SoilService soilService;

    @GetMapping
    public ResponseEntity<Object> getAllAmostras() {
        return ResponseEntity.ok(soilService.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> createAmostra(@RequestBody RequestSoil amostraSolo) {
        try {
            soilService.addSamples(amostraSolo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
