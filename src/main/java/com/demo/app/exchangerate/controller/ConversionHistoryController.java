package com.demo.app.exchangerate.controller;

import com.demo.app.exchangerate.dto.ConversionHistoryDto;
import com.demo.app.exchangerate.model.ConversionHistory;
import com.demo.app.exchangerate.service.ConversionHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@CrossOrigin(origins = "${application.cors.origins}", allowCredentials = "true", methods = {GET, OPTIONS})
@RequestMapping("/conversions-history")
@AllArgsConstructor
@RestController
public class ConversionHistoryController {

    private final ConversionHistoryService conversionHistoryService;

    @GetMapping
    public List<ConversionHistoryDto> getAll() {
        final List<ConversionHistory> conversionsHistory = conversionHistoryService.getAll();
        return conversionsHistory.stream().map(ConversionHistoryDto::new).collect(toList());
    }
}

