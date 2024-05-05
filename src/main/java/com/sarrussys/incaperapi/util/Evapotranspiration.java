package com.sarrussys.incaperapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Evapotranspiration {
    private final double CP = 0.408; // Constante de Penman
    private final double Const_Psico = 0.063; // Constante psicrométrica (kPa/°C)
    //private final double Calor_Espec = 1.013; // Calor específico do ar (kPa/°C)
    private final double Const_Vent = 0.34; // Constante de ventilação
    //private final double Press_Atm = 101.3; // Pressão atmosférica (kPa)
    private final double Conversao = 0.408; // Fator de conversão

    // Método para calcular a evapotranspiração utilizando a fórmula de Penman-Monteith
    public double calculateEvapotranspiration(double delta, double rn, double g, double t, double u2, double es, double ea) {
        double numerator = CP * delta * (rn - g) + Const_Psico * (900 / (t + 273)) * u2 * (es - ea);
        double denominator = delta + Const_Psico * (1 + Const_Vent * u2);
        return (numerator / denominator) * Conversao;
    }
}
