package com.example.app4.rest;

import com.example.app4.entity.Customer;
import com.example.app4.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "customer", description = "customer API")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Validated
public class CustomerRestController {
    private final CustomerService service;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Customer> findById(@NotNull @PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findAll() {
        return service.findAll();
    }


    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@Valid @RequestBody Customer customer) {
        service.insert(customer);
    }

}
