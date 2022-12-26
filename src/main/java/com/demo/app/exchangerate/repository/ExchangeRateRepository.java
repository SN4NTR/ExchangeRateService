package com.demo.app.exchangerate.repository;

import com.demo.app.exchangerate.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, UUID> {

    ExchangeRate findByCurrency(final String currency);
}
