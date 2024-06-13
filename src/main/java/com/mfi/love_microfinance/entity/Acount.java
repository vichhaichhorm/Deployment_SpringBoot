package com.mfi.love_microfinance.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Acount {
    @Id
    @GeneratedValue
    private  Integer id;
    private  Float amount;
    private  Integer term;
    private  Float rate;
    private LocalDate debusdate;
    private Float deposit=0.0f;
    private  Boolean close=false;
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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LandTitle> landTitles;

    @OneToMany(mappedBy = "account")

    private List<Schedule> schedule;
}
