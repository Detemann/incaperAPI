package com.sarrussys.incaperapi.model.user;

public record RequestUser(Integer id,
                          String name,
                          String password,
                          String email) { }
