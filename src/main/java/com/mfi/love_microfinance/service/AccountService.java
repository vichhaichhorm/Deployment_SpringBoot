package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.*;
import com.mfi.love_microfinance.models.*;
import com.mfi.love_microfinance.repository.*;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private AcountRepository acountRepository;
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private LanTitleRepository lanTitleRepository;
@Autowired
    PaymentRepository paymentRepository;
    public List<AcountModel> getAllAccount(){
        List<Acount> accounts=acountRepository.findAll();
        List<AcountModel> acountModels = new ArrayList<>();
        for (Acount acount: accounts
        ) {
            Float os=0.0f;
            AcountModel acountModel=new AcountModel();
            acountModel.setId(acount.getId());
            acountModel.setAmount(acount.getAmount());
            acountModel.setRate(acount.getRate());
            acountModel.setTerm(acount.getTerm());
            acountModel.setCoId(acount.getCo().getId());
            acountModel.setCoName(acount.getCo().getName());
            acountModel.setAaId(acount.getAa().getId());
            acountModel.setAaName(acount.getAa().getName());
            acountModel.setBmId(acount.getBm().getId());
            acountModel.setBmName(acount.getBm().getName());
            acountModel.setDebusdate(acount.getDebusdate());
            acountModel.setClose(acount.getClose());
            acountModel.setFirsMemberName(acount.getClient1().getName());
            acountModel.setFirstMemberId(acount.getClient1().getId());
            acountModel.setSecondMemberName(acount.getClient2().getName());
            acountModel.setSecondMemberId(acount.getClient2().getId());
            acountModel.setDeposit(acount.getDeposit());
           List<Schedule> schedules= acount.getSchedule();

           for(Schedule schedule:schedules){
               if(!schedule.getIsPaid()){
                   os=schedule.getOs()+schedule.getPrincipalDue();
                   break;
               }
           }
            acountModel.setOs(os);
           acountModel.setAddress(acount.getClient1().getAddress());
            acountModels.add(acountModel);
        }

        return acountModels;
    }

    public AcountModel getAccountById(Integer id){
        Acount acount=acountRepository.findById(id).orElse(null);
        AcountModel acountModel=new AcountModel();
        List<LandTitleModel> landTitleModels=new ArrayList<>();
        for(LandTitle landTitle:acount.getLandTitles()){
            LandTitleModel landTitleModel=new LandTitleModel();
            landTitleModel.setId(landTitle.getId());
            landTitleModel.setType(landTitle.getType());
            landTitleModel.setArea(landTitle.getArea());
            landTitleModel.setSecondOwner(landTitle.getSecondOwner());
            landTitleModel.setFirstOwner(landTitle.getFirstOwner());
            landTitleModel.setConfirmBy(landTitle.getConfirmBy());
            landTitleModel.setAddress(landTitle.getAddress());
            landTitleModels.add(landTitleModel);
        }
        acountModel.setLandTitles(landTitleModels);
        acountModel.setId(acount.getId());
        acountModel.setAmount(acount.getAmount());
        acountModel.setRate(acount.getRate());
        acountModel.setTerm(acount.getTerm());
        acountModel.setCoId(acount.getCo().getId());
        acountModel.setCoName(acount.getCo().getName());
        acountModel.setAaId(acount.getAa().getId());
        acountModel.setAaName(acount.getAa().getName());
        acountModel.setBmId(acount.getBm().getId());
        acountModel.setBmName(acount.getBm().getName());
        acountModel.setDebusdate(acount.getDebusdate());
        acountModel.setClose(acount.getClose());
        acountModel.setFirsMemberName(acount.getClient1().getName());
        acountModel.setFirstMemberId(acount.getClient1().getId());
        acountModel.setSecondMemberName(acount.getClient2().getName());
        acountModel.setSecondMemberId(acount.getClient2().getId());
        acountModel.setAddress(acount.getClient1().getAddress());
        acountModel.setDeposit(acount.getDeposit());
        List<Schedule> schedules=acount.getSchedule();
        for(Schedule schedule:schedules){
            if(!schedule.getIsPaid()){
                acountModel.setOs(schedule.getOs()+schedule.getPrincipalDue());
                break;
            }
        }

        return  acountModel;
    }

    public AcountModel createAccount(AcountModel acountModel){
        Acount acount=new Acount();
        if(acountModel.getDebusdate()==null){
            acountModel.setDebusdate(LocalDate.now());
        }
        System.out.println("Hello test one");
        acount.setAmount(acountModel.getAmount());
        acount.setRate(acountModel.getRate());
        acount.setTerm(acountModel.getTerm());
        acount.setDebusdate(acountModel.getDebusdate());
        acount.setDeposit(acountModel.getDeposit());
        Stuff co=stuffRepository.findById(acountModel.getCoId()).orElse(null);
        Stuff aa=stuffRepository.findById(acountModel.getAaId()).orElse(null);
        Stuff bm=stuffRepository.findById(acountModel.getBmId()).orElse(null);

        Client first=clientRepository.findById(acountModel.getFirstMemberId()).orElse(null);
        Client second=clientRepository.findById(acountModel.getSecondMemberId()).orElse(null);
        acount.setCo(co);
        acount.setAa(aa);
        acount.setBm(bm);
        acount.setClient1(first);
        acount.setClient2(second);
        if(co !=null && aa!=null && bm !=null && first!=null && second!=null){
            System.out.println("Hello test two");
            Acount saveAcount=acountRepository.save(acount);
            acountModel.setId(saveAcount.getId());
            acountModel.setCoName(saveAcount.getCo().getName());
            acountModel.setAaName(saveAcount.getAa().getName());
            acountModel.setBmName(saveAcount.getBm().getName());
            acountModel.setFirsMemberName(saveAcount.getClient1().getName());
            acountModel.setSecondMemberName(saveAcount.getClient2().getName());
            acountModel.setDeposit(saveAcount.getDeposit());
            acountModel.setClose(saveAcount.getClose());

            scheduleService.createSchedule(acountModel);
            return  acountModel;
        }

        return  null;
    }

    public  String closeAccount(Integer id){

       Acount acount=acountRepository.findById(id).orElse(null);
       if(acount!=null){
           acount.setClose(true);
           acountRepository.save(acount);
           return  "Acount id: "+id+" close! Successfully";
       }
        return  null;
    }

    public SheduleResponModel getTable(Integer id){
        Acount acount=acountRepository.findById(id).orElse(null);
        SheduleResponModel sheduleResponModel=new SheduleResponModel();
        List<TableModel> tablesModels=new ArrayList<>();
        sheduleResponModel.setId(acount.getId());
        sheduleResponModel.setDebusdate(acount.getDebusdate());
        sheduleResponModel.setAmount(acount.getAmount());
        sheduleResponModel.setRate(acount.getRate());
        sheduleResponModel.setTerm(acount.getTerm());
        sheduleResponModel.setAaName(acount.getAa().getName());
        sheduleResponModel.setCoName(acount.getCo().getName());
        sheduleResponModel.setFirsMemberName(acount.getClient1().getName());
        sheduleResponModel.setSecondMemberName(acount.getClient2().getName());
        sheduleResponModel.setAddress(acount.getClient1().getAddress());

        for(int i=0;i<acount.getSchedule().size()-1;i++) {

            for (int j = 0; j < acount.getSchedule().size() - i - 1; j++) {
                if (acount.getSchedule().get(j).getDueDate().isAfter(acount.getSchedule().get(j + 1).getDueDate())) {

                    Schedule schedule = acount.getSchedule().get(j);
                    acount.getSchedule().set(j, acount.getSchedule().get(j + 1));
                    acount.getSchedule().set(j + 1, schedule);
                }
            }
        }

        for (Schedule shedule:acount.getSchedule()
             ) {
                TableModel tableModel=new TableModel();
                tableModel.setOs(shedule.getOs());
                tableModel.setInterest(shedule.getInterest());
                tableModel.setDueDate(shedule.getDueDate());
                tableModel.setTotal(shedule.getTotal());
                tableModel.setPrincipalDue(shedule.getPrincipalDue());
            tablesModels.add(tableModel);

        }
        sheduleResponModel.setTable(tablesModels);
        return  sheduleResponModel;
    }    public SheduleResponModel getTableHistory(Integer id){
        Acount acount=acountRepository.findById(id).orElse(null);
        SheduleResponModel sheduleResponModel=new SheduleResponModel();
        List<TableModel> tablesModels=new ArrayList<>();
        sheduleResponModel.setId(acount.getId());
        sheduleResponModel.setDebusdate(acount.getDebusdate());
        sheduleResponModel.setAmount(acount.getAmount());
        sheduleResponModel.setRate(acount.getRate());
        sheduleResponModel.setTerm(acount.getTerm());
        sheduleResponModel.setAaName(acount.getAa().getName());
        sheduleResponModel.setCoName(acount.getCo().getName());
        sheduleResponModel.setFirsMemberName(acount.getClient1().getName());
        sheduleResponModel.setSecondMemberName(acount.getClient2().getName());
        sheduleResponModel.setAddress(acount.getClient1().getAddress());

        //sort

        for(int i=0;i<acount.getSchedule().size()-1;i++){

            for(int j=0;j<acount.getSchedule().size()-i-1;j++){
                if(acount.getSchedule().get(j).getDueDate().isAfter(acount.getSchedule().get(j+1).getDueDate())){

                    Schedule   schedule=acount.getSchedule().get(j);
                    acount.getSchedule().set(j,acount.getSchedule().get(j+1));
                    acount.getSchedule().set(j+1,schedule);
                }
            }


        }

        for (Schedule shedule:acount.getSchedule()
             ) {
                TableModel tableModel=new TableModel();
                tableModel.setOs(shedule.getOs());
                tableModel.setInterest(shedule.getInterest());
                tableModel.setDueDate(shedule.getDueDate());
                tableModel.setTotal(shedule.getTotal());
                tableModel.setPrincipalDue(shedule.getPrincipalDue());
                tableModel.setDayOverdue(shedule.getDayOverdue());
            tablesModels.add(tableModel);

        }
        sheduleResponModel.setTable(tablesModels);
        return  sheduleResponModel;
    }

    public String runSystem(){
        List<Acount> acounts=acountRepository.findAll();
        for(Acount acount:acounts){
                //sort
            for(int i=0;i<acount.getSchedule().size()-1;i++){

                for(int j=0;j<acount.getSchedule().size()-i-1;j++){
                    if(acount.getSchedule().get(j).getDueDate().isAfter(acount.getSchedule().get(j+1).getDueDate())){

                        Schedule   schedule=acount.getSchedule().get(j);
                        acount.getSchedule().set(j,acount.getSchedule().get(j+1));
                        acount.getSchedule().set(j+1,schedule);
                    }
                }


            }
            for(Schedule schedule:acount.getSchedule()){
                LocalDate now=LocalDate.now();



                if(!schedule.getIsPaid()){

                    if(now.isAfter(schedule.getDueDate())){
                        float money=acount.getDeposit()-schedule.getTotal();
                        if(money<0){
                            acount.setDeposit(0.0f);
                            schedule.setLackOfPayment(Math.abs(money));
                            schedule.setIsPaid(false);
                            long day= ChronoUnit.DAYS.between(schedule.getDueDate(), now);
                            schedule.setDayOverdue(String.valueOf(day));
                            System.out.println("Day : "+String.valueOf(day));
                            scheduleRepository.save(schedule);

                        }
                        else{
                            acount.setDeposit(money);
                            schedule.setLackOfPayment(0.0f);
                            schedule.setIsPaid(true);

                            scheduleRepository.save(schedule);

                        }

                    }

                    break  ;
                }
            }

        }
        return  "finish";
    }

public String repay(PaymentModel paymentModel){
        System.out.println("Paymetn in account service");


        Acount acount=acountRepository.findById(paymentModel.getAccountId()).orElse(null);
        if(acount==null){
            return  "not have this account ID : "+paymentModel.getAccountId();
        }
    Float money=paymentModel.getAmount();
    for (Schedule schedule: acount.getSchedule()
         ) {
        if( (schedule.getDueDate().isBefore(LocalDate.now()) || schedule.getDueDate().equals(LocalDate.now())) && !schedule.getIsPaid() && money>0){

            money=money- schedule.getTotal();
            if(money>0){

                schedule.setIsPaid(true);
                schedule.setLackOfPayment(0.0f);
                scheduleRepository.save(schedule);
            }
            else{
                schedule.setLackOfPayment(Math.abs(money));
                scheduleRepository.save(schedule);
                break;
            }
        }
        else {
            break;
        }
    }
    acount.setDeposit(money);
    acountRepository.save(acount);
    Payment payment=new Payment();
    payment.setAccount(acount);
    payment.setDatePay(LocalDateTime.now());
    payment.setAmount(paymentModel.getAmount());
    paymentRepository.save(payment);
        return  "Successfully";
}

public  List<PaymentModel> historyPayment(Integer id){
        Acount acount=acountRepository.findById(id).orElse(null);
        List<PaymentModel> payments=new ArrayList<>();
        if(acount!=null){
            for(Payment payment:acount.getPayments()){
                PaymentModel paymentModel=new PaymentModel();
                paymentModel.setAmount(payment.getAmount());
                paymentModel.setDate(payment.getDatePay());
                paymentModel.setId(payment.getId());
                payments.add(paymentModel);
            }

            return  payments;
        }

        return  null;
}


public AccountResponeForPayment checkAccountBeforePay(Integer id){
        AccountResponeForPayment accountResponeForPayment=new AccountResponeForPayment();
        Acount acount=acountRepository.findById(id).orElse(null);
        if(acount!=null){
            accountResponeForPayment.setAccountId(acount.getId());
            accountResponeForPayment.setName(acount.getClient1().getName());
            return  accountResponeForPayment;
        }
        return  null;
}

public  LoanOverDueModel getAllLoanOverDues(){
        LoanOverDueModel loanOverDueModel=new LoanOverDueModel();
        List<Acount> acounts=acountRepository.findAll();
        List<Long> years=new ArrayList<>();
        List<Long> loanDisburses=new ArrayList<>();
        List<ScheduleOverDue> scheduleOverDues=new ArrayList<>();
        for(int i=0;i<4;i++){
            years.add(Long.valueOf(LocalDate.now().getYear()-i));


            int finalI = i;
            long count = acounts.stream()
                    .filter(event -> event.getDebusdate().getYear() == years.get(finalI))
                    .count();
            loanDisburses.add(count);

        }

        loanOverDueModel.setLoanDisburses(loanDisburses);
        loanOverDueModel.setYears(years);
        loanOverDueModel.setLoans(acounts.size());
        System.out.println("Test Schedule overdue");
        Float os=0.f;
        int par=0;
        int par30=0;
        int npl=0;
        int writeOff=0;

        for(Acount acount:acounts){
            //sort
            for(int i=0;i<acount.getSchedule().size()-1;i++){

                for(int j=0;j<acount.getSchedule().size()-i-1;j++){
                    if(acount.getSchedule().get(j).getDueDate().isBefore(acount.getSchedule().get(j+1).getDueDate())){

                        Schedule   schedule=acount.getSchedule().get(j);
                        acount.getSchedule().set(j,acount.getSchedule().get(j+1));
                        acount.getSchedule().set(j+1,schedule);
                    }
                }

            }
//filter schedule
            for(Schedule schedule:acount.getSchedule()){

                if(schedule.getIsPaid()){
                    os+=schedule.getOs()+schedule.getPrincipalDue();
                    break;
                }
                if(!Objects.equals(schedule.getDayOverdue(), "") && schedule.getDayOverdue() != null && !schedule.getDayOverdue().equals(" ")){
                    ScheduleOverDue scheduleOverDue=new ScheduleOverDue();
                    scheduleOverDue.setAccountId(acount.getId());
                    scheduleOverDue.setAccountName(acount.getClient1().getName());
                    scheduleOverDue.setCoName(String.valueOf(acount.getCo().getId())+": "+acount.getCo().getName());
                    scheduleOverDue.setDisburseDate(acount.getDebusdate());
                    scheduleOverDue.setDisburseAmount(acount.getAmount());
                    scheduleOverDue.setPrincipalDue(schedule.getPrincipalDue());
                    scheduleOverDue.setInterestDue(schedule.getInterest());
                    scheduleOverDue.setTotalDue(schedule.getTotal());
                    scheduleOverDue.setDateDue(schedule.getDueDate());
                    int day=Integer.valueOf(schedule.getDayOverdue());
                    scheduleOverDue.setDayOverDue(day);
                    scheduleOverDue.setPhone(acount.getClient1().getPhone());
                    scheduleOverDue.setAddress(acount.getClient1().getAddress());
                    scheduleOverDue.setOs(schedule.getOs()+schedule.getPrincipalDue());

                    os+=schedule.getOs()+schedule.getPrincipalDue();
                    if(day>360){
                        writeOff++;
                    }
                    else if(day >89){
                        npl++;
                    }else if(day >30){
                        par30++;
                    }
                    else{
                        par++;
                    }
                    scheduleOverDues.add(scheduleOverDue);
                }
            }

        }
loanOverDueModel.setScheduleOverDues(scheduleOverDues);
        List<Integer> qlyLoans=new ArrayList<>();
        int normal=loanOverDueModel.getLoans()-par-par30-npl-writeOff;
        qlyLoans.add(normal);
        qlyLoans.add(par);
        qlyLoans.add(par30);
        qlyLoans.add(npl);
        qlyLoans.add(writeOff);
        loanOverDueModel.setQlyLoans(qlyLoans);
        loanOverDueModel.setOs(Double.valueOf(os));
        loanOverDueModel.setNormal(normal);
        return loanOverDueModel;
}


}



