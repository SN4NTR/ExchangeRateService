package com.demo.app.exchangerate.provider;

import com.demo.app.core.web.converter.XmlConverter;
import com.demo.app.exchangerate.converter.EuropeanCentralBankExchangeRateConverter;
import com.demo.app.exchangerate.dto.EuropeanCentralBankExchangeRateDto;
import com.demo.app.exchangerate.model.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Component
public class EuropeanCentralBankExchangeRateProvider {

    public static final String ECB_EXCHANGE_RATE_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private final RestTemplate restTemplate;

    public List<ExchangeRate> provide() {
        final EuropeanCentralBankExchangeRateDto exchangeRateDto = getFromResource();
        return EuropeanCentralBankExchangeRateConverter.toModels(exchangeRateDto);
    }

    private EuropeanCentralBankExchangeRateDto getFromResource() {
        final String exchangeRateXml = restTemplate.getForObject(ECB_EXCHANGE_RATE_URL, String.class);
        return XmlConverter.fromXml(exchangeRateXml, EuropeanCentralBankExchangeRateDto.class);
    }
}
