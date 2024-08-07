package com.magret.client.dto;

public record CustomerResponse(
        String id,
        String firstName,
        String lastname,
        String email
) { }
