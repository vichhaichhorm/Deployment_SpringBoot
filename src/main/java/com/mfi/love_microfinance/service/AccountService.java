package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.*;
import com.mfi.love_microfinance.models.AcountModel;
import com.mfi.love_microfinance.models.TableModel;
import com.mfi.love_microfinance.models.SheduleResponModel;
import com.mfi.love_microfinance.repository.AcountRepository;
import com.mfi.love_microfinance.repository.ClientRepository;
import com.mfi.love_microfinance.repository.StuffRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<AcountModel> getAllAccount(){
        List<Acount> accounts=acountRepository.findAll();
        List<AcountModel> acountModels = new ArrayList<>();
        for (Acount acount: accounts
        ) {
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
            acountModels.add(acountModel);
        }

        return acountModels;
    }

    public AcountModel getAccountById(Integer id){
        Acount acount=acountRepository.findById(id).orElse(null);
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


        return  acountModel;
    }

    public AcountModel createAccount(AcountModel acountModel){
        Acount acount=new Acount();
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
            System.out.println("HHHHHHHHH    Paasss HHHHHHHHHHHHH          ");
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
    }


}
