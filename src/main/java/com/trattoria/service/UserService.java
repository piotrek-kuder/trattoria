package com.trattoria.service;

import com.trattoria.domain.User;

import java.util.Scanner;

public class UserService {

    public User createUser() {

        String name = null;
        String email = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("First we need to create user account");

        while (!isNameValid(name)) {
            System.out.println("Please type your username, only letters and digits allowed:");
            name = scanner.nextLine();
        }

        while (!isEmailValid(email)) {
            System.out.println("Please type your email, email should match pattern local@domain:");
            email = scanner.nextLine();
        }

        System.out.println("Creating new account, user: " + name + " email: " + email);
        return new User(name, email);
    }

    private boolean isNameValid(String name) {

        if ((name == null) || (name.equals("")) || (!name.matches("[a-zA-Z0-9]*"))) {
            return false;
        }
        return true;
    }

    private boolean isEmailValid(String email) {
        if ((email == null) || (email.equals("")) || (!email.matches("^(.+)@(.+)$"))) {
            return false;
        }
        return true;
    }
}
