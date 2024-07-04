package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.models.*;
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
    @PostMapping("/runsystem")
    public  String runSystem(){
        return  accountService.runSystem();
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
    @GetMapping("/history/{id}")
    public  SheduleResponModel getTableHistory(@PathVariable Integer id){
        return  accountService.getTableHistory(id);
    }
    @PostMapping("/pay")
    public  String repay(@RequestBody PaymentModel paymentModel){
        System.out.println("Paymetn in account controller");
        return  accountService.repay(paymentModel);
    }
    @GetMapping("/pay/{id}")
    public  List<PaymentModel> historyPayment(@PathVariable Integer id){
        System.out.println("Paymetn in account controller");
        return  accountService.historyPayment(id);
    }
    @GetMapping("/checkbeforepay/{id}")
    public AccountResponeForPayment checkAccountBeforePay(@PathVariable Integer id){
        return  accountService.checkAccountBeforePay(id);
    }
    @GetMapping("/overdue")
    public LoanOverDueModel getAllLoanOverDue(){

        return accountService.getAllLoanOverDues();
    }

}
