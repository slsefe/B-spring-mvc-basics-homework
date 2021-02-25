package com.thoughtworks.capacity.gtb.mvc.exception;

public class AccountNotExistedException extends RuntimeException{
    public AccountNotExistedException() {
        super("The account is not existed, please sign up first.");
    }
}
