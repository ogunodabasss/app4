package com.example.app4.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString()
@Getter(onMethod = @__(@JsonProperty))
public final class PaymentDTO extends PaymentBaseDTO {


    @NotNull
    private final Long id;

    @NotNull
    private final BigDecimal amount;

    @NotNull
    private final LocalDateTime createdDate;

    @NotNull
    private final CustomerDTO customer;


    public PaymentDTO(Long id, BigDecimal amount, LocalDateTime createdDate, Long customer_id, String customer_cardNo) {

        this.id = id;
        this.amount = amount;
        this.createdDate = createdDate;
        this.customer = new CustomerDTO(customer_id, customer_cardNo);
    }

    public static @NotNull PaymentDTO of(Long id, BigDecimal amount, LocalDateTime createdDate, Long customer_id, String customer_cardNo) {
        return new PaymentDTO(id, amount, createdDate, customer_id, customer_cardNo);
    }
}
