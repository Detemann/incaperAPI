package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.soil.RequestSoil;
import com.sarrussys.incaperapi.model.soil.Soil;
import com.sarrussys.incaperapi.repositories.SoilRepository;
import com.sarrussys.incaperapi.controllers.RequestGeneralDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class SoilService {

    @Autowired
    private SoilRepository soloRepository;

    public List<Soil> getAll() {
        List<Soil> soil = soloRepository.findAll();
        if (soil.isEmpty()) throw new NoSuchElementException("Dados do solo não encontrados");
        return soil;
    }

    public Soil getById(Integer id) {
        if (Objects.isNull(id)) throw new NullPointerException("Campo ID não pode ser nulo");
        Optional<Soil> soil = soloRepository.findById(id);
        return soil.orElseGet(() -> {
            throw new NoSuchElementException("Dados do solo com id {" + id + "} não encontrados");
        });
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
