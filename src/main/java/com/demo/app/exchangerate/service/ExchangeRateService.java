package com.demo.app.exchangerate.service;

import com.demo.app.exchangerate.model.ExchangeRate;
import com.demo.app.exchangerate.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> getAll() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate getByCurrency(final String currency) {
        return exchangeRateRepository.findByCurrency(currency);
    }

    public List<ExchangeRate> saveAll(final List<ExchangeRate> exchangeRates) {
        return exchangeRateRepository.saveAll(exchangeRates);
    }

    public long count() {
        return exchangeRateRepository.count();
    }

    public void deleteAll() {
        exchangeRateRepository.deleteAll();
    }
}
