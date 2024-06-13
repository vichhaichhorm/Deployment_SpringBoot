package com.mfi.love_microfinance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue
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
    private String phone;
    @OneToMany(mappedBy = "client1")
    private List<Acount> acount1;
    @OneToMany(mappedBy = "client2")
    private  List<Acount> acount2;
}
