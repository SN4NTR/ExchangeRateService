package com.demo.app.exchangerate.controller;

import com.demo.app.exchangerate.dto.CurrenciesConversionDto;
import com.demo.app.exchangerate.dto.ExchangeRateDto;
import com.demo.app.exchangerate.model.ExchangeRate;
import com.demo.app.exchangerate.service.CurrenciesConversionService;
import com.demo.app.exchangerate.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "${application.cors.origins}", allowCredentials = "true", methods = {GET, POST, OPTIONS})
@RequestMapping("/exchange-rates")
@AllArgsConstructor
@RestController
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;
    private final CurrenciesConversionService currenciesConversionService;

    @GetMapping
    public List<ExchangeRateDto> getAll() {
        final List<ExchangeRate> exchangeRates = exchangeRateService.getAll();
        return exchangeRates.stream().map(ExchangeRateDto::new).collect(toList());
    }

    @PostMapping("/actions/convert")
    public Float convertCurrencies(@RequestBody final CurrenciesConversionDto currenciesConversionDto) {
        final String fromCurrency = currenciesConversionDto.getFromCurrency();
        final String toCurrency = currenciesConversionDto.getToCurrency();
        final Float amount = currenciesConversionDto.getAmount();
        return currenciesConversionService.convert(fromCurrency, toCurrency, amount);
    }
}

