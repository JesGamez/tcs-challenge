package com.example.coinexchange.controller;

import com.example.coinexchange.dto.ExchangeRateDto;
import com.example.coinexchange.entity.ExchangeRate;
import com.example.coinexchange.entity.enums.CurrencyType;
import com.example.coinexchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("rates")
@PreAuthorize("hasAuthority('SCOPE_admin')")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService service;

    @PostMapping
    public ExchangeRate create(@RequestBody ExchangeRateDto exchangeRate) {
        ExchangeRate entity = new ExchangeRate();
        BeanUtils.copyProperties(exchangeRate, entity);
        return service.create(entity);
    }

    @PreAuthorize("hasAuthority('SCOPE_user')")
    @GetMapping
    public Optional<ExchangeRate> findByCurrency(@RequestParam("currencyType") CurrencyType currencyType) {
        return service.findByCurrency(currencyType);
    }
}
