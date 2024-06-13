package com.mfi.love_microfinance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class LandTitle {
    @Id
    @GeneratedValue
    private  Integer id;
    private  String  type;
    private  String confirmBy;
    private  String firstOwner;
    private  String secondOwner;
    private  Float area;
    private  String address;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Acount account;
}
