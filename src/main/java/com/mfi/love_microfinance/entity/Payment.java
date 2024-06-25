package com.mfi.love_microfinance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private  Integer id;
    private  Float amount;
    private LocalDateTime datePay;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Acount account;
}
