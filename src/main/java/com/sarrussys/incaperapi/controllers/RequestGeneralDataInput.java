package com.sarrussys.incaperapi.controllers;

public record RequestGeneralDataInput(Integer deviceId,
                                      Double temperaturaSub,
                                      Double temperaturaAci,
                                      Double umidade_perc,
                                      Double n_perc,
                                      Double p_perc,
                                      Double k_perc,
                                      Double temperature,
                                      Double humidity,
                                      Integer pluviometer,
                                      String date,
                                      String time) { }
