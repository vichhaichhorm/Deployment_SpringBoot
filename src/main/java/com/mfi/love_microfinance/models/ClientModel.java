package com.mfi.love_microfinance.models;


import lombok.Data;

import java.util.Date;

@Data
public class ClientModel {
    private  Integer id;
    private  String name;
    private  Character sex;
    private Date dob;
    private String cid;
    private  String address;
    private  String job;
    private  Float salary;
    private  String education;
    private  Boolean status;

}
