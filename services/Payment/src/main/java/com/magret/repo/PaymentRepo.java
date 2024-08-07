package com.magret.repo;

import com.magret.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment , Integer> {
}
