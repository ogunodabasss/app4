package com.example.app4.repository;

import com.example.app4.entity.Payment;
import com.example.app4.entity.dto.PaymentBaseDTO;
import com.example.app4.utils.entity.norepository.ReadDTORepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentReadRepository extends ReadDTORepository<PaymentBaseDTO, Payment, Long> {


    <R extends PaymentBaseDTO> List<R> findAllByCustomer_CardNoOrderByCreatedDateDesc(String cardNo, Class<R> clazz);

    <R extends PaymentBaseDTO> List<R> findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanOrderByCreatedDateDesc(LocalDateTime start, LocalDateTime end, Class<R> clazz);

    <R extends PaymentBaseDTO> List<R> findAllByCustomer_CardNo_AndCreatedDateGreaterThanEqualAndCreatedDateLessThanOrderByCreatedDateDesc(String cardNo, LocalDateTime start, LocalDateTime end, Class<R> clazz);

    @Override
    <R extends PaymentBaseDTO> List<R> findAllBy(Class<R> clazz);

    @Override
    <R extends PaymentBaseDTO> R findById(Long id, Class<R> clazz);

    @Override
    <R extends PaymentBaseDTO> List<R> findByIdIn(Iterable<Long> ids, Class<R> clazz);

    @Override
    <R extends PaymentBaseDTO> List<R> findByIdIn(Long[] ids, Class<R> clazz);
}
