package com.demo.app.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Table(name = "user_account")
@Entity
@Getter
@Setter
public class User {

    @Id
    @Column
    private UUID id = randomUUID();

    private String username;

    private String password;
}
