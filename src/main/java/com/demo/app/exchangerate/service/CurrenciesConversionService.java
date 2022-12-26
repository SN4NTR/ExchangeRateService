package com.demo.app.exchangerate.service;

import com.demo.app.exchangerate.model.ConversionHistory;
import com.demo.app.exchangerate.model.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CurrenciesConversionService {

    private final ExchangeRateService exchangeRateService;
    private final ConversionHistoryService conversionHistoryService;

    public Float convert(final String fromCurrency, final String toCurrency, final Float amount) {
        final ExchangeRate fromExchangeRate = exchangeRateService.getByCurrency(fromCurrency);
        final Float fromRate = fromExchangeRate.getRate();
        final ExchangeRate toExchangeRate = exchangeRateService.getByCurrency(toCurrency);
        final Float toRate = toExchangeRate.getRate();

        saveInHistory(fromExchangeRate, toExchangeRate, amount);

        return amount / fromRate * toRate;
    }

    private void saveInHistory(final ExchangeRate fromExchangeRate, final ExchangeRate toExchangeRate, final Float amount) {
        final ConversionHistory conversionHistory = buildHistory(fromExchangeRate, toExchangeRate, amount);
        conversionHistoryService.save(conversionHistory);
    }

    private ConversionHistory buildHistory(final ExchangeRate fromExchangeRate, final ExchangeRate toExchangeRate, final Float amount) {
        final LocalDate date = fromExchangeRate.getDate();
        final String fromCurrency = fromExchangeRate.getCurrency();
        final Float fromCurrencyRate = fromExchangeRate.getRate();
        final String toCurrency = toExchangeRate.getCurrency();
        final Float toCurrencyRate = toExchangeRate.getRate();

        final ConversionHistory conversionHistory = new ConversionHistory();
        conversionHistory.setFromCurrency(fromCurrency);
        conversionHistory.setFromCurrencyRate(fromCurrencyRate);
        conversionHistory.setToCurrency(toCurrency);
        conversionHistory.setToCurrencyRate(toCurrencyRate);
        conversionHistory.setAmount(amount);
        conversionHistory.setDate(date);
        return conversionHistory;
    }
}
