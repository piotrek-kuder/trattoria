package com.trattoria.service;

import com.trattoria.domain.User;

public class UserService {

    public boolean validateNameAndEmail(String name, String email) {
        return false;      //todo
    }

    public User createUser(String name, String email) {
        return new User(name, email);
    }
}
