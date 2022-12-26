package com.demo.app.user.service;

import com.demo.app.user.model.User;
import com.demo.app.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }
}
