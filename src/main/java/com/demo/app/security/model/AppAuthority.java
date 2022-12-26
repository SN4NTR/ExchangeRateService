package com.demo.app.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppAuthority {

    APPLICATION_MANAGER("ApplicationManager"),
    USER("User");

    private final String value;
}
