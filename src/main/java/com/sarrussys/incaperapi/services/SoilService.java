package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.soil.RequestSoil;
import com.sarrussys.incaperapi.model.soil.Soil;
import com.sarrussys.incaperapi.model.soil.SoilRepository;
import com.sarrussys.incaperapi.controllers.RequestGeneralDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class SoilService {

    @Autowired
    private SoilRepository soloRepository;

    public List<Soil> getAllSamples() {
        return soloRepository.getSoilByDataHora();
    }

    public void addSamples(RequestSoil amostraSolo) throws ParseException {
        Soil newSoil = new Soil(amostraSolo);
        soloRepository.save(newSoil);
    }

    public void addSamplesGeneralInput(RequestGeneralDataInput amostraSolo) throws ParseException {
        Soil newSoil = new Soil(amostraSolo);
        soloRepository.save(newSoil);
    }
}
