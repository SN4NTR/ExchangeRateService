package com.demo.app.exchangerate.repository;

import com.demo.app.exchangerate.model.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, UUID> {
}
