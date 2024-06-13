package com.mfi.love_microfinance.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class ScheduleModel {

    private LocalDate dueDate;
    private Float os;
    private Float interest;
    private Float principalDue;
    private String dayOverdue="";
    private Boolean isPaid=false;
    private Float total=0.0f;

}
