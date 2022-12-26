package com.demo.app.exchangerate.service;

import com.demo.app.exchangerate.model.ConversionHistory;
import com.demo.app.exchangerate.repository.ConversionHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConversionHistoryService {

    private final ConversionHistoryRepository conversionHistoryRepository;

    public List<ConversionHistory> getAll() {
        return conversionHistoryRepository.findAll();
    }

    public ConversionHistory save(final ConversionHistory conversionHistory) {
        return conversionHistoryRepository.save(conversionHistory);
    }
}
