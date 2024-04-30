package com.sarrussys.incaperAPI.Model.device;

public record RequestDevice(Integer id,
                            Integer ownerId,
                            String lastLog) { }
