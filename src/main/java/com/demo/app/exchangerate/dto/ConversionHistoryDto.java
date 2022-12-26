package com.demo.app.exchangerate.dto;

import com.demo.app.exchangerate.model.ConversionHistory;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConversionHistoryDto {

    private String fromCurrency;

    private Float fromCurrencyRate;

    private String toCurrency;

    private Float toCurrencyRate;

    private Float amount;

    private LocalDate date;

    public ConversionHistoryDto(final ConversionHistory conversionHistory) {
        this.fromCurrency = conversionHistory.getFromCurrency();
        this.fromCurrencyRate = conversionHistory.getFromCurrencyRate();
        this.toCurrency = conversionHistory.getToCurrency();
        this.toCurrencyRate = conversionHistory.getToCurrencyRate();
        this.amount = conversionHistory.getAmount();
        this.date = conversionHistory.getDate();
    }
}
