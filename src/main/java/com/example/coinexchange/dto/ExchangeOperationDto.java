package com.example.coinexchange.dto;

import com.example.coinexchange.entity.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ExchangeOperationDto {
    private UUID id;
    private Double amount;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;
}
