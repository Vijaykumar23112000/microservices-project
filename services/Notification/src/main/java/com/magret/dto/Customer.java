package com.magret.dto;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) { }
