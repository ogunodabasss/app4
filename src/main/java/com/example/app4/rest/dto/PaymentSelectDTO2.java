package com.example.app4.rest.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PaymentSelectDTO2(@NotNull LocalDateTime start,
                                @NotNull LocalDateTime end
) {

    @AssertTrue
    boolean isValidDate() {
        return start.isBefore(end);
    }
}