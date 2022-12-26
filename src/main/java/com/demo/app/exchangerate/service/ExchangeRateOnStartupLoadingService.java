package com.demo.app.exchangerate.service;

import com.demo.app.exchangerate.model.ExchangeRate;
import com.demo.app.exchangerate.provider.EuropeanCentralBankExchangeRateProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@AllArgsConstructor
@Service
@Slf4j
public class ExchangeRateOnStartupLoadingService {

    private final EuropeanCentralBankExchangeRateProvider exchangeRateProvider;
    private final ExchangeRateService exchangeRateService;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        log.info("Exchange rate on startup loading is started.");

        requestAndSaveAllIfNeeded();

        log.info("Exchange rate on startup loading is finished.");
    }

    private void requestAndSaveAllIfNeeded() {
        if (exchangeRateService.count() == 0) {
            final List<ExchangeRate> exchangeRates = tryToRequestAllFromProvider();
            exchangeRateService.saveAll(exchangeRates);
        }
    }

    private List<ExchangeRate> tryToRequestAllFromProvider() {
        try {
            return exchangeRateProvider.provide();
        } catch (Exception ex) {
            log.error("Failed to request exchange rate using {}.", exchangeRateProvider.getClass().getSimpleName());
            return emptyList();
        }
    }
}
