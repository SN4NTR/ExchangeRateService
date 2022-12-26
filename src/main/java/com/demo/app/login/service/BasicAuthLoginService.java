package com.demo.app.login.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

@AllArgsConstructor
@Service
public class BasicAuthLoginService {

    private final AuthenticationManager authenticationManager;

    public String login(final String username, final String password) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return RequestContextHolder.currentRequestAttributes().getSessionId();
    }
}
