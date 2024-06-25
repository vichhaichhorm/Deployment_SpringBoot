package com.mfi.love_microfinance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private  Integer id;
    private LocalDate dueDate;
    private Float os;
    private Float interest;
    private Float principalDue;
    private String dayOverdue="";
    private Boolean isPaid=false;
    private  Float total=0.0f;
    private  Float lackOfPayment=0.0f;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Acount account;
}
