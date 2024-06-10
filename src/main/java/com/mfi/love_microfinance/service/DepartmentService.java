package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.models.DepartmentModel;
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

    public  Department createDepartment(Department department){
        return  departmentRepository.save(department);
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

    public  void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }
}
