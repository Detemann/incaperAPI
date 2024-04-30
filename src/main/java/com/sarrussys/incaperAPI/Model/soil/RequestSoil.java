package com.sarrussys.incaperAPI.Model.soil;

public record RequestSoil(Integer id,
                          Integer deviceId,
                          Double temperaturaSub,
                          Double temperaturaAci,
                          Double umidade_perc,
                          Double n_perc,
                          Double p_perc,
                          Double k_perc,
                          String data,
                          String hora) { }
