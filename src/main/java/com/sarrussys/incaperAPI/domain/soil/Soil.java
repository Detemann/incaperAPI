package com.sarrussys.incaperAPI.domain.soil;

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

    @Column(name = "umidade_perc")
    private double umidade_perc;
    @Column(name = "n_perc")
    private double n_perc;
    @Column(name = "p_perc")
    private double p_perc;
    @Column(name = "k_perc")
    private double k_perc;

    public Soil(RequestSoil soil) {
        this.umidade_perc = soil.umidade_perc();
        this.n_perc = soil.n_perc();
        this.p_perc = soil.p_perc();
        this.k_perc = soil.k_perc();
    }
}
