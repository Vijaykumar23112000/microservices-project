package com.magret.enumeration;

import lombok.Getter;

@Getter
public enum EmailTemplate {

    PAYMENT_CONFIRMATION("payment-confirmation.html","Payment Successfully Processed"),
    ORDER_CONFIRMATION("order-confirmation.html","Order Successfully Processed");

    private final String template;
    private final String subject;

    EmailTemplate(String template , String subject){
        this.template = template;
        this.subject = subject;
    }

}
