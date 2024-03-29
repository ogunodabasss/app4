package com.example.app4.entity.dto;

import com.example.app4.utils.entity.norepository.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class CustomerBaseDTO extends AbstractDTO {
}