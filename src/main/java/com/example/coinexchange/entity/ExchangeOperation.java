package com.example.coinexchange.entity;

import com.example.coinexchange.entity.enums.CurrencyType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class ExchangeOperation {
    @GeneratedValue
    private @Id Long id;
    private UUID uuid;
    private Double amount;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;

    public UUID getUuid() {
        return UUID.randomUUID();
    }
}
