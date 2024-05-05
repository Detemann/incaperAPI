package com.sarrussys.incaperapi.controllers;

import com.sarrussys.incaperapi.services.AtmosphereService;
import com.sarrussys.incaperapi.services.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/samples")
@CrossOrigin
public class GeneralDataInput {
    @Autowired
    private AtmosphereService atmosphereService;

    @Autowired
    private SoilService soilService;

    @PostMapping
    public ResponseEntity<Object> reciveAllData(RequestGeneralDataInput newGeneralDataInput) {
        try {
            atmosphereService.addSampleGenralInput(newGeneralDataInput);
            soilService.addSamplesGeneralInput(newGeneralDataInput);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
