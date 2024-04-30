package com.sarrussys.incaperAPI.Model.user;

public record RequestUser(Integer id,
                          String name,
                          String password,
                          String email) { }
