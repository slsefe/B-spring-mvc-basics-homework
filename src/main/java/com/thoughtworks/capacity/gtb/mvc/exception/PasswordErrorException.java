package com.thoughtworks.capacity.gtb.mvc.exception;

public class PasswordErrorException extends RuntimeException{
    public PasswordErrorException() {
        super("The password is wrong, please input the correct password.");
    }
}
