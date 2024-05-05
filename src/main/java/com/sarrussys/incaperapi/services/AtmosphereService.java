package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.atmosphere.Atmosphere;
import com.sarrussys.incaperapi.repositories.AtmosphereRepository;
import com.sarrussys.incaperapi.model.atmosphere.RequestAtmosphere;
import com.sarrussys.incaperapi.controllers.RequestGeneralDataInput;
import com.sarrussys.incaperapi.util.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class AtmosphereService {
    @Autowired
    private AtmosphereRepository atmosphereRepository;

    Check check = new Check();

    public List<Atmosphere> getAll() {
        List<Atmosphere> atmospheres = atmosphereRepository.findAll();
        if (atmospheres.isEmpty()) throw new NoSuchElementException("Dados atmosféricos não encontrados");
        return atmospheres;
    }

    public Atmosphere getById(Integer id) {
        if (Objects.isNull(id)) throw new NullPointerException("Campo ID não pode ser nulo");
        Optional<Atmosphere> atmosphere = atmosphereRepository.findById(id);
        return atmosphere.orElseGet(() -> {
            throw new NoSuchElementException("Dados atmosféricos com id {" + id + "} não encontrados");
        });
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

