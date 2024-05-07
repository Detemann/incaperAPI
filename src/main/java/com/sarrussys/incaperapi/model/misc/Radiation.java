package com.sarrussys.incaperapi.model.misc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "radiation_data")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Radiation {
        @Id
        Integer lat;
        @Column(name = "monthnum")
        int monthNum;
        double radiation;
}