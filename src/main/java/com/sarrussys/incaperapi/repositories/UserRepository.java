package com.sarrussys.incaperapi.repositories;

import com.sarrussys.incaperapi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
