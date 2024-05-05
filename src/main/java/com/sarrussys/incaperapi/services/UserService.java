package com.sarrussys.incaperapi.services;

import com.sarrussys.incaperapi.model.user.User;
import com.sarrussys.incaperapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) throw new NoSuchElementException("Dados dos usuários não encontrados");
        return users;
    }

    public User getById(Integer id) {
        if (Objects.isNull(id)) throw new NullPointerException("Campo ID não pode ser nulo");
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(() -> {
            throw new NoSuchElementException("Dados do usuário com id {" + id + "} não encontrados");
        });
    }
}
