package com.magret.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product Is Mandatory")
        Integer productId,
        @NotNull(message = "Quantity Is Mandatory")
        double quantity
) { }
