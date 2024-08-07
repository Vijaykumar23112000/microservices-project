package com.magret.dto;

import com.magret.enumeration.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order amount must be positive")
        BigDecimal amount,
        @NotNull(message = "Payment Method cannot b null")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer cannot be null")
        @NotEmpty(message = "Customer cannot be empty")
        @NotBlank(message = "Customer cannot be blank")
        String customerId,
        @NotEmpty(message = "You should atleat purchase one product")
        List<PurchaseRequest> products
) { }
