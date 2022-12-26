package com.demo.app.exchangerate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Table(name = "exchange_rate")
@Getter
@Setter
@Entity
public class ExchangeRate {

    @Id
    @Column
    private UUID id = randomUUID();

    @Column
    private String currency;

    @Column
    private Float rate;

    @Column
    private LocalDate date;
}
