package com.example.app4.utils.entity.norepository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public abstract class AbstractDTO {
}