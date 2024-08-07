package com.magret.dto;

import com.magret.client.dto.CustomerResponse;
import com.magret.client.dto.PurchaseResponse;
import com.magret.enumeration.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount ,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) { }
