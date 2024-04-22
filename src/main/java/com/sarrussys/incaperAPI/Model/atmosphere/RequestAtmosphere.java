package com.sarrussys.incaperAPI.Model.atmosphere;

public record RequestAtmosphere(Integer id,
                                Double temperature,
                                Double humidity,
                                Double pluviometer) { }
