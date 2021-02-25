package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserController {
    private final UserService userService;
    private final String userNameRegExp = "^[a-zA-Z0-9_]{3,10}$";
    private final String userNameErrorMessage = "Illegal username";
    private final String passwordRegExp = "^.{5,12}$";
    private final String passwordErrorMessage = "Illegal password";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam(name = "username")
                             @Pattern(regexp = userNameRegExp, message = userNameErrorMessage)
                                     String username,
                         @RequestParam(name = "password")
                             @Pattern(regexp = passwordRegExp, message = passwordErrorMessage)
                                 String password,
                         @Email String email) {
        userService.createUser(username, password, email);
    }

    @GetMapping("/login")
    public User login(@RequestParam(name = "username")
                          @Pattern(regexp = userNameRegExp, message = userNameErrorMessage)
                                  String username,
                      @RequestParam(name = "password")
                      @Pattern(regexp = passwordRegExp, message = passwordErrorMessage)
                              String password) {
        return userService.login(username, password);
    }

}
