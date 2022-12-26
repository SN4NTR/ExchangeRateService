package com.demo.app.security.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("management.auth.user")
@Component
@Data
public class ManagementCredentials {

    private String name;

    private String password;
}
