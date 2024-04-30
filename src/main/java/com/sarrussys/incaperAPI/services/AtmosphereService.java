package com.sarrussys.incaperAPI.services;

import com.sarrussys.incaperAPI.Model.atmosphere.Atmosphere;
import com.sarrussys.incaperAPI.Model.atmosphere.AtmosphereRepository;
import com.sarrussys.incaperAPI.Model.atmosphere.RequestAtmosphere;
import com.sarrussys.incaperAPI.Model.soil.Soil;
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
}
