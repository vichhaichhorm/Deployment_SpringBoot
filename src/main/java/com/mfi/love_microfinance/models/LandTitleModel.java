package com.mfi.love_microfinance.models;

import lombok.Data;

@Data
public class LandTitleModel {
    private  Integer id;
    private  String  type;
    private  String confirmBy;
    private  String firstOwner;
    private  String secondOwner;
    private  Float area;
    private  String address;
    private  Integer accountId;

}
