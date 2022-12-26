package com.demo.app.user.service;

import com.demo.app.user.model.User;

import java.util.Optional;

public interface UserService {

    User save(final User user);

    Optional<User> findByUsername(final String username);
}
