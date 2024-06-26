package com.mfi.love_microfinance.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AcountModel {
    private  Integer id;
    private  Float amount;
    private  Integer term;
    private  Float rate;
    private LocalDate debusdate;
    private  Integer coId;
    private  Integer aaId;
    private  Integer bmId;
    private  String coName;
    private String bmName;
    private  String aaName;
    private  Boolean close=false;
    private  Float deposit=0.0f;

    private  Integer firstMemberId;
    private  String firsMemberName;
    private  Integer secondMemberId;
    private  String secondMemberName;
    private  String address;
    private Float os;

}
