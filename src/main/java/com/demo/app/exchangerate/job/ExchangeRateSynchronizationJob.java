package com.demo.app.exchangerate.job;

import com.demo.app.exchangerate.service.ExchangeRateSynchronizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class ExchangeRateSynchronizationJob {

    private final ExchangeRateSynchronizationService exchangeRateSynchronizationService;

    @Scheduled(cron = "0 10 16 * * 1-5", zone = "CET")
    public void synchronize() {
        exchangeRateSynchronizationService.synchronize();
    }
}
