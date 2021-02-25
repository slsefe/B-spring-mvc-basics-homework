package com.thoughtworks.capacity.gtb.mvc.exception;

public class AccountExistedException extends RuntimeException{
    public AccountExistedException() {
        super("The account is existed, please sign in directly.");
    }
}
