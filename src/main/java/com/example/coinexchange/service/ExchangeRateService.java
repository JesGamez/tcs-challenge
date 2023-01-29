package com.example.coinexchange.service;

import com.example.coinexchange.entity.ExchangeRate;
import com.example.coinexchange.entity.enums.CurrencyType;

import java.util.Optional;

public interface ExchangeRateService {
    ExchangeRate create(ExchangeRate exchangeRate);

    ExchangeRate update(ExchangeRate exchangeRate);

    Optional<ExchangeRate> findOneById(Long id);

    Optional<ExchangeRate> findByCurrency(CurrencyType currency);

    Iterable<ExchangeRate> findAll();
}
