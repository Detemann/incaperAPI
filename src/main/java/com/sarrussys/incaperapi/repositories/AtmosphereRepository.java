package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.atmosphere.Atmosphere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AtmosphereRepository extends JpaRepository<Atmosphere, Integer> {
    @Query(value = "SELECT * " +
            "FROM atmosphere_data atm " +
            "WHERE atm.data_hora > CURRENT_DATE " +
            "AND atm.data_hora < CURRENT_DATE + INTERVAL '1 day' - INTERVAL '1 second';", nativeQuery = true)
    public List<Atmosphere> getByDate(Date date);
}
