package com.sarrussys.incaperAPI.Model.soil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "data")
    private String data;
    @Column(name = "hora")
    private String hora;

    public Soil(RequestSoil soil) {
        this.temperaturaSub = soil.temperaturaSub();
        this.temperaturaAci = soil.temperaturaAci();
        this.umidade_perc = soil.umidade_perc();
        this.n_perc = soil.n_perc();
        this.p_perc = soil.p_perc();
        this.k_perc = soil.k_perc();
        this.hora = soil.hora();
        this.data = soil.data();
    }
}
