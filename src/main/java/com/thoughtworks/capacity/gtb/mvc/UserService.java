package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.AccountNotExistedException;
import com.thoughtworks.capacity.gtb.mvc.exception.AccountExistedException;
import com.thoughtworks.capacity.gtb.mvc.exception.PasswordErrorException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> users = new HashMap<>();

    public UserService() {

    }

    public void createUser(String username, String password, String email) {
        Integer id = username.hashCode();
        if (users.containsKey(id)) {
            throw new AccountExistedException();
        }
        User user = new User(id, username, password, email);
        users.put(id, user);
    }

    public User login(String username, String password) {
        Integer id  = username.hashCode();
        if (!users.containsKey(id)) {
            throw new AccountNotExistedException();
        }

        User user = users.get(id);
        if (!user.getPassword().equals(password)) {
            throw new PasswordErrorException();
        }

        return user;
    }

}
