package com.ikra.exception;

public class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1684364820513146099L;

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
