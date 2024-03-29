package com.example.app4.entity;

import com.example.app4.entity.mappedSuperclass.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@ToString(onlyExplicitlyIncluded = true,callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})

@Entity
@Table
public class Customer extends BaseEntity {
    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(nullable = false, length = 30)
    private String name;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(nullable = false, length = 30)
    private String surName;

    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotNull
    @Size(min = 5, max = 40)
    @Column(nullable = false, length = 40,unique = true)
    private String email;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(nullable = false, length = 11, unique = true)
    private String tc;

    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    @Size(min = 5, max = 5)
    @Column(nullable = false, length = 5, unique = true)
    private String cardNo;

    @JsonIgnore
    @NotNull
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "customer", cascade = CascadeType.ALL)
    private final Set<Payment> payments = new HashSet<>(0);

    public void addPayment(Payment payment){
        payments.add(payment);
        payment.setCustomer(this);
    }

    public void addAllPayment(Collection<? extends Payment> c){
        payments.addAll(c);
        c.forEach(order -> order.setCustomer(this));
    }

    public void removePayment(Payment order){
        payments.remove(order);
        order.setCustomer(null);
    }

}

