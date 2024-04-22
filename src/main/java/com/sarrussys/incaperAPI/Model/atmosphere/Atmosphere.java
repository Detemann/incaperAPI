package com.sarrussys.incaperAPI.Model.atmosphere;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "atmosphere_data")
@Entity(name = "atmosphere")
@Getter
@Setter
@NoArgsConstructor
public class Atmosphere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "humidity")
    private Double humidity;
    @Column(name = "pluviometer")
    private Integer pluviometer;
    /*@Column(name = "data")
    private Date date;*/

    public Atmosphere(Integer id, Double temperature, Double humidity, Double pluviometer) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pluviometer = Math.toIntExact(Math.round(pluviometer));
    }

    public Atmosphere(RequestAtmosphere requestAtmosphere) {
        this.temperature = requestAtmosphere.temperature();
        this.humidity = requestAtmosphere.humidity();
        this.pluviometer = Math.toIntExact(Math.round(requestAtmosphere.pluviometer()));
    }
}
