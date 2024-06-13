package com.mfi.love_microfinance.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TableModel {
    private LocalDate dueDate;
    private Float os;
    private Float interest;
    private Float principalDue;
    private Float total=0.0f;

}
