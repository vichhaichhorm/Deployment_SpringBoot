package com.mfi.love_microfinance.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Acount {
    @Id
    @GeneratedValue
    private  Integer id;
    private  Float amount;
    private  Integer term;
    private  Float rate;
    private Date debusdate;
    @ManyToOne
    @JoinColumn(name = "client1_id")
    private Client  client1;
    @ManyToOne
    @JoinColumn(name = "client2_id")
    private Client client2;

    @ManyToOne
    @JoinColumn(name = "co_id")
    private  Stuff co;
    @ManyToOne
    @JoinColumn(name = "aa_id")
    private  Stuff aa;
    @ManyToOne
    @JoinColumn(name = "bm_id")
    private  Stuff bm;
}
