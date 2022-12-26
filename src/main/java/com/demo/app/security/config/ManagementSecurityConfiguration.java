package com.demo.app.security.config;

import com.demo.app.security.model.ManagementCredentials;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.demo.app.security.model.AppAuthority.APPLICATION_MANAGER;

@Order(ManagementSecurityConfiguration.MANAGEMENT_AUTH_ORDER)
@AllArgsConstructor
@Configuration
public class ManagementSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final int MANAGEMENT_AUTH_ORDER = 1;

    private final ManagementCredentials managementCredentials;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(EndpointRequest.to("actuator"))
                .csrf().ignoringRequestMatchers(EndpointRequest.to("loggers"))
                .and()
                .requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
                .requestMatchers(EndpointRequest.to("health", "info")).permitAll()
                .requestMatchers(EndpointRequest.to("loggers")).hasAuthority(APPLICATION_MANAGER.getValue())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final String managementAdminUsername = managementCredentials.getName();
        final String managementAdminPassword = managementCredentials.getPassword();
        final String encodedPassword = passwordEncoder.encode(managementAdminPassword);
        auth.inMemoryAuthentication()
                .withUser(managementAdminUsername)
                .password(encodedPassword)
                .authorities(APPLICATION_MANAGER.getValue());
    }
}
