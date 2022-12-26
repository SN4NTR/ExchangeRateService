package com.demo.app.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.demo.app.security.config.BasicAuthSecurityConfiguration.BASIC_AUTH_ORDER;
import static org.springframework.security.config.http.SessionCreationPolicy.ALWAYS;

@Order(BASIC_AUTH_ORDER)
@AllArgsConstructor
@Configuration
public class BasicAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final int BASIC_AUTH_ORDER = ManagementSecurityConfiguration.MANAGEMENT_AUTH_ORDER + 1;

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .sessionManagement().sessionCreationPolicy(ALWAYS)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
