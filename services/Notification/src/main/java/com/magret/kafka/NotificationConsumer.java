package com.magret.kafka;

import com.magret.dto.OrderConfirmation;
import com.magret.dto.PaymentConfirmation;
import com.magret.entity.Notification;
import com.magret.enumeration.NotificationType;
import com.magret.repo.NotificationRepo;
import com.magret.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.magret.enumeration.NotificationType.*;
import static java.lang.String.format;
import static java.time.LocalDateTime.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepo repo;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consuming Message from payment-topic : Topic:: %s",paymentConfirmation));
        repo.save(
                Notification
                        .builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        var customerName = paymentConfirmation.customerFirstname()+" "+paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );

    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consuming Message from order-topic : Topic:: %s",orderConfirmation));
        repo.save(
                Notification
                        .builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        var customerName = orderConfirmation.customer().firstname()+" "+orderConfirmation.customer().lastname();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }


}
