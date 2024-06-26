package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.soil.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoilRepository extends JpaRepository<Soil, Integer> {
    @Query("SELECT sd FROM soil sd ORDER BY (sd.dataHora - CURRENT_DATE)")
    List<Soil> getSoilByDataHora();
}
