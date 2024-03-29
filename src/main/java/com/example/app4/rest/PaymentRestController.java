package com.example.app4.rest;

import com.example.app4.entity.Payment;
import com.example.app4.entity.dto.PaymentDTO;
import com.example.app4.rest.dto.PaymentSelectDTO;
import com.example.app4.rest.dto.PaymentSelectDTO2;
import com.example.app4.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "payment", description = "payment API")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Validated
public class PaymentRestController {

    private final PaymentService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Payment> findById(@NotNull @PathVariable Long id) {
        return service.findById(id);
    }


    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Payment.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> findAll() {
        return service.findAll();
    }


    @GetMapping(value = "/findAllByCustomer_CardNo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentDTO> findAllByCustomer_CardNo(@Valid @RequestParam @NotNull @Size(min = 5, max = 5) String cardNo) {
        return service.findAllByCustomer_CardNo(cardNo, PaymentDTO.class);
    }

    @GetMapping(value = "/findAllByCreatedDateBetween", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentDTO> findAllByCreatedDateBetween(@Valid PaymentSelectDTO2 selectDTO) {
        return service.findAllByCreatedDateBetween(selectDTO, PaymentDTO.class);
    }

    @GetMapping(value = "/findAllByCardNoAndCreatedDateBetween", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentDTO> findAllByCardNoAndCreatedDateBetween(@Valid PaymentSelectDTO selectDTO) {
        return service.findAllByCardNoAndCreatedDateBetween(selectDTO, PaymentDTO.class);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@Valid @RequestBody Payment payment) {
        service.insert(payment);
    }
}
