package com.mfi.love_microfinance.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SheduleResponModel {
    private  Integer id;
    private  Float amount;
    private  Integer term;
    private  Float rate;
    private LocalDate debusdate;
    private  String coName;
    private  String aaName;
    private  String firsMemberName;
    private  String secondMemberName;
    private  String address;
    private String phone;
    private List<TableModel> table;

}
