package com.demo.app.exchangerate.service;

import com.demo.app.exchangerate.model.ExchangeRate;
import com.demo.app.exchangerate.provider.EuropeanCentralBankExchangeRateProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Collections.emptyList;

@AllArgsConstructor
@Service
@Slf4j
public class ExchangeRateSynchronizationService {

    private final EuropeanCentralBankExchangeRateProvider exchangeRateProvider;
    private final ExchangeRateService exchangeRateService;

    @Transactional
    public void synchronize() {
        log.info("Exchange rates synchronization daily job is started.");

        requestAndSaveAll();

        log.info("Exchange rates synchronization daily job is finished.");
    }

    private void requestAndSaveAll() {
        final List<ExchangeRate> newExchangeRates = tryToRequestFromProvider();
        if (!newExchangeRates.isEmpty()) {
            exchangeRateService.deleteAll();
            exchangeRateService.saveAll(newExchangeRates);
        }
    }

    private List<ExchangeRate> tryToRequestFromProvider() {
        try {
            return exchangeRateProvider.provide();
        } catch (Exception ex) {
            log.error("Failed to request exchange rate using {}.", exchangeRateProvider.getClass().getSimpleName());
            return emptyList();
        }
    }
}
