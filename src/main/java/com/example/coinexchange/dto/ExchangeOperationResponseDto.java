package com.example.coinexchange.dto;

import com.example.coinexchange.entity.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ExchangeOperationResponseDto {
    private UUID operationId;
    private Double amount;
    private Double amountWithRate;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;
    private ExchangeRateResponseDto exchangeRate;
}
