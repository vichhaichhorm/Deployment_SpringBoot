package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.entity.Stuff;
import com.mfi.love_microfinance.repository.StuffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffService {
    private final StuffRepository stuffRepository;

    public StuffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }


    public List<Stuff> getAllStuff(){
        return stuffRepository.findAll();
    }

    public Stuff getStuffById(Integer id){
        return  stuffRepository.findById(id).orElse(null);
    }

    public  Stuff createStuff(Stuff stuff){
        return  stuffRepository.save(stuff);
    }

    public  Stuff updateStuff(Integer id, Stuff stuffDetails){
       Stuff  stuff =stuffRepository.findById(id).orElse(null);
        if(stuff!=null){
            stuff.setName(stuffDetails.getName());
            stuff.setDepartment(stuffDetails.getDepartment());
            return  stuffRepository.save(stuff);
        }
        return  null;
    }

    public  void deleteStuff(Integer id){
        stuffRepository.deleteById(id);
    }
}
