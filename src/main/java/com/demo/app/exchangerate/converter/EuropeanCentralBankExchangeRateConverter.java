package com.demo.app.exchangerate.converter;

import com.demo.app.exchangerate.dto.EuropeanCentralBankExchangeRateDto;
import com.demo.app.exchangerate.dto.EuropeanCentralBankExchangeRateDto.CubeDto.DateCubeDto.CurrencyRateCubeDto;
import com.demo.app.exchangerate.model.ExchangeRate;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EuropeanCentralBankExchangeRateConverter {

    public static List<ExchangeRate> toModels(final EuropeanCentralBankExchangeRateDto dto) {
        final LocalDate date = dto.getDate();
        final List<CurrencyRateCubeDto> currencyRates = dto.getCurrencyRates();
        return currencyRates.stream()
                .map(it -> buildExchangeRateByCurrencyRateAndDate(it, date))
                .collect(toList());
    }

    private static ExchangeRate buildExchangeRateByCurrencyRateAndDate(final CurrencyRateCubeDto currencyRate, final LocalDate date) {
        final String currency = currencyRate.getCurrency();
        final Float rate = currencyRate.getRate();

        final ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setDate(date);
        exchangeRate.setCurrency(currency);
        exchangeRate.setRate(rate);
        return exchangeRate;
    }
}
