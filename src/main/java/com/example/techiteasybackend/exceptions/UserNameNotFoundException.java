package com.example.techiteasybackend.exceptions;

public class UserNameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserNameNotFoundException(String username) {
        super("Cannot find user " + username);
    }
}
