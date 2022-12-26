package com.demo.app.login.controller;

import com.demo.app.login.dto.LoginDto;
import com.demo.app.login.dto.SessionDto;
import com.demo.app.login.service.BasicAuthLoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "${application.cors.origins}", allowCredentials = "true", methods = {POST, OPTIONS})
@RequestMapping("/login")
@AllArgsConstructor
@RestController
public class LoginController {

    private final BasicAuthLoginService basicAuthLoginService;

    @PostMapping
    public SessionDto login(@RequestBody final LoginDto loginDto) {
        final String username = loginDto.getUsername();
        final String password = loginDto.getPassword();
        final String sessionId = basicAuthLoginService.login(username, password);
        return new SessionDto(sessionId);
    }
}
