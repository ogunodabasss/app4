package com.example.app4.service;

import com.example.app4.entity.Customer;
import com.example.app4.repository.CustomerReadRepository;
import com.example.app4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerReadRepository readRepository;
    private final ThreadPoolExecutor threadPoolExecutor;

    public void insert(Customer customer) {
        var savedEntity = repository.save(customer);
        threadPoolExecutor.execute(() -> log.info("Customer-Insert:\n {}\n", savedEntity));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
        threadPoolExecutor.execute(() -> log.info("Customer-deleteById:\n {}\n", id));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }
}
