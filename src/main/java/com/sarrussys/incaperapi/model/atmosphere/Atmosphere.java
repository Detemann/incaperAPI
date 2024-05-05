package com.sarrussys.incaperapi.model.atmosphere;

import com.sarrussys.incaperapi.controllers.RequestGeneralDataInput;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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
    @Column(name = "dataHora")
    private Date dataHora;
    @Column(name = "deviceId")
    private Integer deviceId;

    public Atmosphere(Integer id, Double temperature, Double humidity, Double pluviometer, Integer deviceId) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pluviometer = Math.toIntExact(Math.round(pluviometer));
        this.deviceId = deviceId;
    }

    public Atmosphere(RequestAtmosphere atmosphere) throws ParseException {
        this.id = atmosphere.id();
        this.temperature = atmosphere.temperature();
        this.humidity = atmosphere.humidity();
        this.pluviometer = Math.toIntExact(Math.round(atmosphere.pluviometer()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.dataHora = dateFormat.parse((atmosphere.date()+" "+atmosphere.time()));
        this.deviceId = atmosphere.deviceId();
    }

    public Atmosphere(RequestGeneralDataInput generalData) throws ParseException {
        this.temperature = generalData.temperature();
        this.humidity = generalData.humidity();
        this.pluviometer = Math.toIntExact(Math.round(generalData.pluviometer()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.dataHora = dateFormat.parse((generalData.date()+" "+generalData.time()));
        this.deviceId = generalData.deviceId();
    }
}
