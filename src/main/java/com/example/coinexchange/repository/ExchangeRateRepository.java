package com.example.coinexchange.repository;

import com.example.coinexchange.entity.ExchangeRate;
import com.example.coinexchange.entity.enums.CurrencyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> getFirstByCurrencyOrderByUpdatedAtAsc(CurrencyType currency);
}
