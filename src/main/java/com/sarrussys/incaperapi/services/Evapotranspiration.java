package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.atmosphere.Atmosphere;
import com.sarrussys.incaperapi.repositories.RadiationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class Evapotranspiration {

    @Autowired
    RadiationRepository radiationRepository;
    private double eto(Double radiation, Double tempMax, Double tempMin, Double tempMed) {
        Double coeficient = 0.0136;
        return 0.0135 * coeficient * radiation * Math.pow((tempMax - tempMin), 0.5) * (tempMed + 17.8);
    }

    public double calcularEvapotranspiracao (List<Atmosphere> atmospheres) {
        Double radiation = radiationRepository.getByLat(20).getRadiation();
        OptionalDouble tempMax = atmospheres.stream().mapToDouble(Atmosphere::getTemperature).max();
        OptionalDouble tempMin = atmospheres.stream().mapToDouble(Atmosphere::getTemperature).min();
        OptionalDouble tempMed = atmospheres.stream().mapToDouble(Atmosphere::getTemperature).average();

        if(!tempMax.isPresent()) throw new NullPointerException("Valor de tempMax não encontrado");
        if(!tempMin.isPresent()) throw new NullPointerException("Valor de tempMin não encontrado");
        if(!tempMed.isPresent()) throw new NullPointerException("Valor de tempMed não encontrado");

        return eto(radiation, tempMax.getAsDouble(), tempMin.getAsDouble(), tempMed.getAsDouble());
    }

//    public static void main(String[] args) {
//        // Exemplo de utilização
//        double delta = 0.18; // Declividade da curva de vapor de pressão (kPa/°C)
//        double rn = 12.5; // Radiação líquida disponível (MJ/m²/dia)
//        double g = 2.5; // Calor do solo (MJ/m²/dia)
//        double t = 25; // Temperatura média diária do ar (°C)
//        double u2 = 3; // Velocidade do vento a 2 metros acima do solo (m/s)
//        double es = 0.85; // Pressão de vapor saturado do ar (kPa)
//        double ea = 0.65; // Pressão de vapor atual do ar (kPa)
//        double kc = 1.2; // Coeficiente de cultura específico da planta
//
//        double et = calcularEvapotranspiracao(delta, rn, g, t, u2, es, ea, kc);
//        System.out.println("Evapotranspiração: " + et);
//    }
}
