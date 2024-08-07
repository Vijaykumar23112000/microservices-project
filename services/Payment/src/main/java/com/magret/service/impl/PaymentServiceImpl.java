package com.magret.service.impl;

import com.magret.dto.PaymentNotificationRequest;
import com.magret.notification.NotificationProducer;
import com.magret.repo.PaymentRepo;
import com.magret.dto.PaymentRequest;
import com.magret.service.PaymentService;
import com.magret.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper mapper;
    private final PaymentRepo repo;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = repo.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }


}
