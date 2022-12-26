
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

@Table(name = "conversion_history")
@Getter
@Setter
@Entity
public class ConversionHistory {

    @Id
    @Column(name = "id")
    private UUID id = randomUUID();

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "from_currency_rate")
    private Float fromCurrencyRate;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "to_currency_rate")
    private Float toCurrencyRate;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private LocalDate date;
}
