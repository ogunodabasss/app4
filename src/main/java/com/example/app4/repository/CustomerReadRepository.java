package com.example.app4.repository;

import com.example.app4.entity.Customer;
import com.example.app4.entity.dto.CustomerBaseDTO;
import com.example.app4.utils.entity.norepository.ReadDTORepository;

public interface CustomerReadRepository extends ReadDTORepository<CustomerBaseDTO, Customer, Long> {
}
