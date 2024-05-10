package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.misc.Radiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RadiationRepository extends JpaRepository<Radiation, Integer> {
    @Query(value = "SELECT r.* " +
            "FROM radiation_data r " +
            "WHERE r.lat = ?1", nativeQuery = true)
   public Radiation getByLat(int lat);
}
