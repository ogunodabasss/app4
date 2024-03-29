package com.example.app4.service;

import com.example.app4.entity.Payment;
import com.example.app4.entity.dto.PaymentBaseDTO;
import com.example.app4.repository.PaymentReadRepository;
import com.example.app4.repository.PaymentRepository;
import com.example.app4.rest.dto.PaymentSelectDTO;
import com.example.app4.rest.dto.PaymentSelectDTO2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentReadRepository readRepository;
    private final ThreadPoolExecutor threadPoolExecutor;

    public void insert(Payment payment) {
        var savedEntity = repository.save(payment);
        threadPoolExecutor.execute(() -> log.info("Payment-Insert:\n {}\n", savedEntity));
    }

    @Transactional(readOnly = true)
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Payment> findById(long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public <R extends PaymentBaseDTO> List<R> findAllByCustomer_CardNo(String cardNo, Class<R> clazz) {
        threadPoolExecutor.execute(() -> log.info("Payment-findAllByCustomer_CardNo:\n {}\n", cardNo));
        return readRepository.findAllByCustomer_CardNoOrderByCreatedDateDesc(cardNo, clazz);
    }

    @Transactional(readOnly = true)
    public <R extends PaymentBaseDTO> List<R> findAllByCreatedDateBetween(PaymentSelectDTO2 paymentSelectDTO, Class<R> clazz) {
        threadPoolExecutor.execute(() -> log.info("Payment-findAllByCreatedDateBetween:\n {}\n", paymentSelectDTO));
        return readRepository.findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanOrderByCreatedDateDesc(paymentSelectDTO.start(), paymentSelectDTO.end().plusDays(1), clazz);
    }

    @Transactional(readOnly = true)
    public <R extends PaymentBaseDTO> List<R> findAllByCardNoAndCreatedDateBetween(PaymentSelectDTO paymentSelectDTO, Class<R> clazz) {
        threadPoolExecutor.execute(() -> log.info("Payment-findAllByCardNoAndCreatedDateBetween:\n {}\n", paymentSelectDTO));
        return readRepository.findAllByCustomer_CardNo_AndCreatedDateGreaterThanEqualAndCreatedDateLessThanOrderByCreatedDateDesc(paymentSelectDTO.cardNo(), paymentSelectDTO.start(), paymentSelectDTO.end().plusDays(1), clazz);
    }
}
