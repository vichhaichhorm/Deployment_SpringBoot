package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.entity.Stuff;
import com.mfi.love_microfinance.models.StuffModel;
import com.mfi.love_microfinance.repository.DepartmentRepository;
import com.mfi.love_microfinance.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StuffService {
    private final StuffRepository stuffRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public StuffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }


    public List<StuffModel> getAllStuff(){
        List<Stuff> stuffs=stuffRepository.findAll();
        List<StuffModel> stuffModels = new ArrayList<>();
        for (Stuff stuff: stuffs
             ) {
            StuffModel stuffModel=new StuffModel();
            stuffModel.setId(stuff.getId());
            stuffModel.setName(stuff.getName());
            stuffModel.setDob(stuff.getDob());
            stuffModel.setSex(stuff.getSex());
            stuffModel.setCid(stuff.getCid());
            stuffModel.setAddress(stuff.getAddress());
            stuffModel.setSalary(stuff.getSalary());
            stuffModel.setStatus(stuff.getStatus());
            stuffModel.setStopWork(stuff.getStopWork());
            stuffModel.setStartWork(stuff.getStartWork());
            stuffModel.setDepartmentId(stuff.getDepartment().getId());
            stuffModel.setDepartmentName(stuff.getDepartment().getName());

            stuffModels.add(stuffModel);
        }

        return stuffModels;
    }

    public StuffModel getStuffById(Integer id){
        Stuff saveStuff=stuffRepository.findById(id).orElse(null);
        StuffModel stuffModel=new StuffModel();

        stuffModel.setId(saveStuff.getId());
        stuffModel.setName(saveStuff.getName());
        stuffModel.setDob(saveStuff.getDob());
        stuffModel.setSex(saveStuff.getSex());
        stuffModel.setCid(saveStuff.getCid());
        stuffModel.setAddress(saveStuff.getAddress());
        stuffModel.setSalary(saveStuff.getSalary());
        stuffModel.setStatus(saveStuff.getStatus());
        stuffModel.setStopWork(saveStuff.getStopWork());
        stuffModel.setStartWork(saveStuff.getStartWork());
        stuffModel.setDepartmentId(saveStuff.getDepartment().getId());
        stuffModel.setDepartmentName(saveStuff.getDepartment().getName());


        return  stuffModel;
    }

    public  StuffModel createStuff(StuffModel stuffModel){
        Stuff stuff=new Stuff();
        stuff.setId(stuffModel.getId());
        stuff.setName(stuffModel.getName());
        stuff.setDob(stuffModel.getDob());
        stuff.setSex(stuffModel.getSex());
        stuff.setCid(stuffModel.getCid());
        stuff.setAddress(stuffModel.getAddress());
        stuff.setSalary(stuffModel.getSalary());
        stuff.setStatus(stuffModel.getStatus());
        stuff.setStopWork(stuffModel.getStopWork());
        stuff.setStartWork(stuffModel.getStartWork());


        var department=departmentRepository.findById(stuffModel.getDepartmentId()).orElse(null);
        stuff.setDepartment(department);
        if(department !=null){
            System.out.println("HHHHHHHHH    Paasss HHHHHHHHHHHHH          ");
            Stuff saveStuff=stuffRepository.save(stuff);
            stuffModel.setId(saveStuff.getId());
            stuffModel.setDepartmentName(department.getName());
            return  stuffModel;
        }





        return  null;
    }

    public  StuffModel updateStuff(Integer id, StuffModel stuffDetails){
       Stuff  stuff =stuffRepository.findById(id).orElse(null);
        if(stuff!=null){
            Department department=departmentRepository.getById(stuffDetails.getDepartmentId());


            stuff.setName(stuffDetails.getName());
            stuff.setDob(stuffDetails.getDob());
            stuff.setSex(stuffDetails.getSex());
            stuff.setCid(stuffDetails.getCid());
            stuff.setAddress(stuffDetails.getAddress());
            stuff.setSalary(stuffDetails.getSalary());
            stuff.setStatus(stuffDetails.getStatus());
            stuff.setStopWork(stuffDetails.getStopWork());
            stuff.setStartWork(stuffDetails.getStartWork());
            stuff.setDepartment(department);

            stuffRepository.save(stuff);
           stuffDetails.setDepartmentName(department.getName());
           stuffDetails.setId(id);

            return  stuffDetails;
        }
        return  null;
    }

    public  void deleteStuff(Integer id){
        stuffRepository.deleteById(id);
    }
}
