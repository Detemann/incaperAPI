package com.sarrussys.incaperAPI.services;

import com.sarrussys.incaperAPI.Model.soil.RequestSoil;
import com.sarrussys.incaperAPI.Model.soil.Soil;
import com.sarrussys.incaperAPI.Model.soil.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilService {

    @Autowired
    private SoilRepository soloRepository;

    public List<Soil> getAllSamples() {
        return soloRepository.findAll();
    }

    public void addSamples(RequestSoil amostraSolo) {
        Soil newSoil = new Soil(amostraSolo);
        soloRepository.save(newSoil);
    }
}
