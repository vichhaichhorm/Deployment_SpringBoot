package com.mfi.love_microfinance.models;

import com.mfi.love_microfinance.entity.Acount;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentModel {
    private  Integer accountId;
    private  Float amount;

}
