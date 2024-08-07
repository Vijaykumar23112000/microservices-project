package com.magret.resource;

import com.magret.dto.PaymentRequest;
import com.magret.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    ResponseEntity<Integer> createPayment(
            @RequestBody @Valid PaymentRequest request
    )
    {
        return ResponseEntity.ok(paymentService.createPayment(request));
    }


}
