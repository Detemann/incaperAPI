package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.atmosphere.Atmosphere;
import com.sarrussys.incaperapi.model.atmosphere.AtmosphereRepository;
import com.sarrussys.incaperapi.model.atmosphere.RequestAtmosphere;
import com.sarrussys.incaperapi.controllers.RequestGeneralDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class AtmosphereService {
    @Autowired
    private AtmosphereRepository atmosphereRepository;

    public List<Atmosphere> getAll() {
        return atmosphereRepository.findAll();
    }

    public void addSample(RequestAtmosphere sample) throws ParseException {
        Atmosphere newSample = new Atmosphere(sample);
        atmosphereRepository.save(newSample);
    }

    public void addSampleGenralInput(RequestGeneralDataInput sample) throws ParseException {
        Atmosphere newSample = new Atmosphere(sample);
        atmosphereRepository.save(newSample);
    }
}

