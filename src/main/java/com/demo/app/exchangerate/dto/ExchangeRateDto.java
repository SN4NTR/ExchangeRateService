package com.demo.app.exchangerate.dto;

import com.demo.app.exchangerate.model.ExchangeRate;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ExchangeRateDto {

    private UUID id;

    private String currency;

    private Float rate;

    private LocalDate date;

    public ExchangeRateDto(final ExchangeRate exchangeRate) {
        this.id = exchangeRate.getId();
        this.currency = exchangeRate.getCurrency();
        this.rate = exchangeRate.getRate();
        this.date = exchangeRate.getDate();
    }
}
