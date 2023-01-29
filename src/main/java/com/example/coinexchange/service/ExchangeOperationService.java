package com.example.coinexchange.service;

import com.example.coinexchange.dto.ExchangeOperationResponseDto;
import com.example.coinexchange.entity.ExchangeOperation;

import java.util.Optional;

public interface ExchangeOperationService {
    ExchangeOperationResponseDto exchange(ExchangeOperation exchangeOperation);

    ExchangeOperation create(ExchangeOperation exchangeOperation);

    Optional<ExchangeOperation> findById(Long id);

    Iterable<ExchangeOperation> findAll();
}
