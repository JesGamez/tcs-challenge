package com.example.coinexchange.service.impl;

import com.example.coinexchange.dto.ExchangeOperationResponseDto;
import com.example.coinexchange.dto.ExchangeRateResponseDto;
import com.example.coinexchange.entity.ExchangeOperation;
import com.example.coinexchange.entity.ExchangeRate;
import com.example.coinexchange.repository.ExchangeOperationRepository;
import com.example.coinexchange.service.ExchangeOperationService;
import com.example.coinexchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeOperationServiceImpl implements ExchangeOperationService {
    private final ExchangeOperationRepository repository;
    private final ExchangeRateService rateService;

    @Override
    public ExchangeOperationResponseDto exchange(ExchangeOperation operation) {
        ExchangeOperationResponseDto response = new ExchangeOperationResponseDto();
        //encontrar el tipo de cambio
        Optional<ExchangeRate> exchangeType = rateService.findByCurrency(operation.getTargetCurrency());
        if (exchangeType.isPresent()) {
            ExchangeRateResponseDto exchangeTypeDto = new ExchangeRateResponseDto();
            BeanUtils.copyProperties(exchangeType.get(), exchangeTypeDto);
            response.setOperationId(operation.getUuid());
            response.setExchangeRate(exchangeTypeDto);
            response.setAmount(operation.getAmount());
            response.setSourceCurrency(operation.getSourceCurrency());
            response.setTargetCurrency(operation.getTargetCurrency());

            // Se calcula la cantidad de dinero que se quiere comparar * el costo
            // del tipo de cambio a la venta de dicha moneda.
            response.setAmountWithRate(operation.getAmount() * exchangeTypeDto.getPurchasePrice());
            return response;
        } else return null;
    }

    @Override
    public ExchangeOperation create(ExchangeOperation exchangeOperation) {
        return repository.save(exchangeOperation);
    }

    @Override
    public Optional<ExchangeOperation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<ExchangeOperation> findAll() {
        return repository.findAll();
    }
}
