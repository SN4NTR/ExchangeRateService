package com.demo.app.user.service;

import com.demo.app.user.model.User;
import com.demo.app.user.model.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userOpt = userService.findByUsername(username);
        return userOpt.map(UserPrincipal::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
