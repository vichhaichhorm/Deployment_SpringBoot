package com.mfi.love_microfinance.models;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ClientModel {
    private  Integer id;
    private  String name;
    private  Character sex;
    private LocalDate dob;
    private String cid;
    private  String address;
    private  String job;
    private  Float salary;
    private  String education;
    private  Boolean status;
    private  String phone;
    private  Boolean haveAccount;

}
