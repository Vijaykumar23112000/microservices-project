package com.magret.dto;

import com.magret.entity.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
)
{ }
