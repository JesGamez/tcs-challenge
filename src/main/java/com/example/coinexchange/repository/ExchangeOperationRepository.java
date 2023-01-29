package com.example.coinexchange.repository;

import com.example.coinexchange.entity.ExchangeOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeOperationRepository extends CrudRepository<ExchangeOperation, Long> {
}
