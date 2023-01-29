package com.example.coinexchange.service.impl;

import com.example.coinexchange.entity.ExchangeRate;
import com.example.coinexchange.entity.enums.CurrencyType;
import com.example.coinexchange.repository.ExchangeRateRepository;
import com.example.coinexchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository repository;

    @Override
    public ExchangeRate create(ExchangeRate exchangeRate) {
        return repository.save(exchangeRate);
    }

    @Override
    public ExchangeRate update(ExchangeRate exchangeRate) {
        return findByCurrency(exchangeRate.getCurrency())
                .map(found -> {
                    found.setPurchasePrice(exchangeRate.getPurchasePrice());
                    found.setSalePrice(found.getSalePrice());
                    return repository.save(found);
                }).orElse(null);
    }

    @Override
    public Optional<ExchangeRate> findOneById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ExchangeRate> findByCurrency(CurrencyType currency) {
        return repository.getFirstByCurrencyOrderByUpdatedAtAsc(currency);
    }

    @Override
    public Iterable<ExchangeRate> findAll() {
        return repository.findAll();
    }
}
