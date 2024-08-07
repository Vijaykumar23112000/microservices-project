package com.magret.service;

import com.magret.dto.PaymentRequest;

public interface PaymentService {

    Integer createPayment(PaymentRequest request);

}
