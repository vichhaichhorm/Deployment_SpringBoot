package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Acount;
import com.mfi.love_microfinance.entity.Schedule;
import com.mfi.love_microfinance.models.AcountModel;
import com.mfi.love_microfinance.repository.AcountRepository;
import com.mfi.love_microfinance.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private AcountRepository acountRepository;
    public String createSchedule(AcountModel acountModel){

        Float p=acountModel.getAmount();
        Float r=acountModel.getRate()/100;
        Integer term=acountModel.getTerm();

        Acount acount=acountRepository.findById(acountModel.getId()).orElse(null);


        LocalDate dueDate = acountModel.getDebusdate();
        int emi=(int)Math.ceil(
                p*r*Math.pow(r+1,term)/(Math.pow(r+1,term)-1)

        );

        for(int i=1;i<term+1;i++){
            Schedule schedule=new Schedule();
            schedule.setAccount(acount);
            int interest=(int)Math.ceil(p*r);

            schedule.setDueDate(dueDate.plusDays(30*i));
            schedule.setTotal((float)emi);
            schedule.setLackOfPayment(0.0f);
            schedule.setInterest((float)interest);
            schedule.setPrincipalDue((float)(emi-interest));
            System.out.println("P: "+p+" - "+(emi-interest)+" = "+(p-emi+interest));
            p=Math.abs(p-emi+interest);
            if(i==term){
                p=0.0f;
            }
            schedule.setOs(p);

            scheduleRepository.save(schedule);
        }
        return  "Yes";
    }

}
