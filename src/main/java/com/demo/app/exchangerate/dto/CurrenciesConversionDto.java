package com.demo.app.exchangerate.dto;

import lombok.Data;

@Data
public class CurrenciesConversionDto {

    private String fromCurrency;

    private String toCurrency;

    private Float amount;
}
