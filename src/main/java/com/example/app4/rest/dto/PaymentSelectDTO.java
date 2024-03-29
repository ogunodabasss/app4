package com.example.app4.rest.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


public record PaymentSelectDTO(@NotNull LocalDateTime start, @NotNull LocalDateTime end,
                               @NotNull @Size(min = 5, max = 5) String cardNo) {

    @AssertTrue
    boolean isValidDate() {
        return start.isBefore(end);
    }
}
