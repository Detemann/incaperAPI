package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.atmosphere.Atmosphere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmosphereRepository extends JpaRepository<Atmosphere, Integer> { }
