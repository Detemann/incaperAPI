package com.sarrussys.incaperAPI.domain.soil;

public record RequestSoil(Integer id, Double umidade_perc, Double n_perc, Double p_perc, Double k_perc, String data, String hora) { }
