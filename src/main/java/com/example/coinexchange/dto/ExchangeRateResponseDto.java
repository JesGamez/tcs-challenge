package com.example.coinexchange.dto;

import com.example.coinexchange.entity.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateResponseDto {
    private String description;
    private CurrencyType currency;
    private Double salePrice;
    private Double purchasePrice;
}
