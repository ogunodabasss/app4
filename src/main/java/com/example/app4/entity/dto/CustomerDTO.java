package com.example.app4.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString()
@Getter(onMethod = @__(@JsonProperty))
@AllArgsConstructor
public final class CustomerDTO extends CustomerBaseDTO {

    @NotNull
    private final Long id;

    @NotNull
    private final String cardNo;
}
