package com.mfi.love_microfinance.repository;

import com.mfi.love_microfinance.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
