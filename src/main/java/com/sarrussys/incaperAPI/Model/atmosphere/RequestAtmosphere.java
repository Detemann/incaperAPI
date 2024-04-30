package com.sarrussys.incaperAPI.Model.atmosphere;

public record RequestAtmosphere(Integer id,
                                Integer deviceId,
                                Double temperature,
                                Double humidity,
                                Double pluviometer,
                                String date,
                                String time) { }
