package com.mfi.love_microfinance.models;

import lombok.Data;

import java.util.Date;

@Data
public class StuffModel {
    private  Integer id;
    private  String name;
    private  Character sex;
    private Date dob;
    private  String cid;
    private  String address;
    private  Boolean status;
    private  Float salary;
    private  Date startWork;
    private  Boolean stopWork;
    private  Integer departmentId;
    private  String departmentName;
}
