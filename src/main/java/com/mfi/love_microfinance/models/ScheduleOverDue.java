package com.mfi.love_microfinance.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduleOverDue {
    private  String coName;
    private Integer accountId;
    private String accountName;
    private LocalDate disburseDate;
    private Float disburseAmount;
    private Float os;
    private  Float principalDue;
    private Float interestDue;
    private Float totalDue;
    private LocalDate dateDue;
    private Integer dayOverDue;
    private String phone;
    private String address;
}
