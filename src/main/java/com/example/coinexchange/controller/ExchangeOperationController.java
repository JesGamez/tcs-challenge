package com.example.coinexchange.controller;

import com.example.coinexchange.dto.ExchangeOperationDto;
import com.example.coinexchange.dto.ExchangeOperationResponseDto;
import com.example.coinexchange.entity.ExchangeOperation;
import com.example.coinexchange.service.ExchangeOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('SCOPE_user')")
@RequestMapping("operations")
@RequiredArgsConstructor
public class ExchangeOperationController {
    private final ExchangeOperationService service;

    @PostMapping
    public ResponseEntity<ExchangeOperationResponseDto> create(@RequestBody ExchangeOperationDto operationDto) {
        ExchangeOperation operation = new ExchangeOperation();
        BeanUtils.copyProperties(operationDto, operation);
        return ResponseEntity.ok(service.exchange(operation));
    }
}
