package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Client;
import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.entity.Stuff;
import com.mfi.love_microfinance.models.DepartmentModel;
import com.mfi.love_microfinance.models.StuffModel;
import com.mfi.love_microfinance.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentModel> getAllDepartment(){
        List<Department> departments=departmentRepository.findAll();
        List<DepartmentModel> departmentModels=new ArrayList<>();
        for (Department department: departments
             ) {
            DepartmentModel departmentModel=new DepartmentModel();
            departmentModel.setId(department.getId());
            departmentModel.setName(department.getName());
            departmentModels.add(departmentModel);

        }
        return departmentModels;
    }

    public DepartmentModel getDepartmentById(Integer id){
        Department department=departmentRepository.findById(id).orElse(null);
        DepartmentModel departmentModel=new DepartmentModel();
        if(department!=null){
            departmentModel.setId(department.getId());
            departmentModel.setName(department.getName());
            return  departmentModel;
        }
        return  null;
    }

    public  DepartmentModel createDepartment(DepartmentModel departmentModel){
        Department department=new Department();
        department.setName(departmentModel.getName());
         department= departmentRepository.save(department);
         departmentModel.setId(department.getId());
        return  departmentModel;
    }

    public  DepartmentModel updateDepartment(Integer id, DepartmentModel departmentDetails){
        Department department=departmentRepository.findById(id).orElse(null);
        if(department!=null){
            department.setName(departmentDetails.getName());
            departmentRepository.save(department);
            departmentDetails.setId(id);
            return  departmentDetails;
        }
        return  null;
    }

    public List<StuffModel> getAllStuffInDepartmentId(Integer id){
        Department department=departmentRepository.findById(id).orElse(null);
        List<StuffModel> stuffModels=new ArrayList<>();
        if(department!=null){
            List<Stuff> stuffs=department.getStuffs();
            for (Stuff stuff:stuffs
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

            return  stuffModels;
        }
        return  null;
    }

    public  void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }
}
