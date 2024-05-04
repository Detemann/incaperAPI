package com.sarrussys.incaperAPI.Model.soil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "soil_data")
@Entity(name = "soil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Soil {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "temperaturaSub")
    private Double temperaturaSub;
    @Column(name = "temperaturaAci")
    private Double temperaturaAci;
    @Column(name = "umidade_perc")
    private Double umidade_perc;
    @Column(name = "n_perc")
    private Double n_perc;
    @Column(name = "p_perc")
    private Double p_perc;
    @Column(name = "k_perc")
    private Double k_perc;
    @Column(name = "dataHora")
    private Date dataHora;
    @Column(name = "deviceId")
    private Integer deviceId;

    public Soil(RequestSoil soil) throws ParseException {
        this.temperaturaSub = soil.temperaturaSub();
        this.temperaturaAci = soil.temperaturaAci();
        this.umidade_perc = soil.umidade_perc();
        this.n_perc = soil.n_perc();
        this.p_perc = soil.p_perc();
        this.k_perc = soil.k_perc();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.dataHora = dateFormat.parse((soil.data()+" "+soil.hora()));
        this.deviceId = soil.deviceId();
    }
}
