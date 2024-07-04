package com.mfi.love_microfinance.models;

import lombok.Data;

import java.util.List;

@Data
public class LoanOverDueModel {
    private List<Long> years;
    private List<Long> loanDisburses;
    private Double os;
    private Integer loans;
    private Integer normal;
    private List<Integer> qlyLoans;
    private  List<ScheduleOverDue> scheduleOverDues;
}
