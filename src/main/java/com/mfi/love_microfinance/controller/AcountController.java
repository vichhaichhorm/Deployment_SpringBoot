package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.models.AcountModel;
import com.mfi.love_microfinance.models.SheduleResponModel;
import com.mfi.love_microfinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AcountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public AcountModel createAccount(@RequestBody AcountModel acountModel){

        return  accountService.createAccount(acountModel);
    }
    @GetMapping
    public List<AcountModel> getAllAccount(){
        return  accountService.getAllAccount();
    }

    @GetMapping("{id}")
    public  AcountModel getAccountById(@PathVariable Integer id){
        return  accountService.getAccountById(id);
    }
    @PostMapping("/close/{id}")
    public  String closeAccountById(@PathVariable Integer id){
        return  accountService.closeAccount(id);
    }
    @GetMapping("/{id}/scheduleclient")
    public SheduleResponModel getScheduleForClient(@PathVariable Integer id){
        return  accountService.getTable(id);
    }

}
