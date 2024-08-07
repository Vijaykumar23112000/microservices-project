package com.magret.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "firstname is required")
        String firstname,
        @NotNull(message = "lastname is required")
        String lastname,
        @NotNull(message = "email is required")
        @Email(message = "customer email is not correctly formatted")
        String email
) { }
