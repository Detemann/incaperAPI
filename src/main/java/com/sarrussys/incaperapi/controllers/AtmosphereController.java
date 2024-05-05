package com.sarrussys.incaperapi.controllers;

import com.sarrussys.incaperapi.model.atmosphere.RequestAtmosphere;
import com.sarrussys.incaperapi.services.AtmosphereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atmosphere")
@CrossOrigin // apague o comentario em caso de erro de CORS
public class AtmosphereController {
    @Autowired
    private AtmosphereService atmosphereService;

    @GetMapping
    public ResponseEntity getAllSamples() {
        return ResponseEntity.ok(atmosphereService.getAll());
    }

    @PostMapping
    public ResponseEntity addSample(@RequestBody RequestAtmosphere newSample) {
        try {
            atmosphereService.addSample(newSample);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
