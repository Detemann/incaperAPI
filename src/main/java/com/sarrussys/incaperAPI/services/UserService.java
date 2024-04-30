package com.sarrussys.incaperAPI.services;

import com.sarrussys.incaperAPI.Model.user.User;
import com.sarrussys.incaperAPI.Model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
