package com.sarrussys.incaperapi.model.device;

public record RequestDevice(Integer id,
                            Integer ownerId,
                            String lastLog) { }
