package com.example.coinexchange.entity;

import com.example.coinexchange.entity.enums.CurrencyType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ExchangeRate {
    @GeneratedValue
    private @Id Long id;
    private String description;
    @Column(unique = true)
    private CurrencyType currency;
    private Double salePrice;
    private Double purchasePrice;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
