package com.mfi.love_microfinance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;
    @OneToMany(mappedBy = "co")
    private List<Acount> acount1;
    @OneToMany(mappedBy = "aa")
    private List<Acount> acount2;
    @OneToMany(mappedBy = "bm")
    private List<Acount> acount3;


}
