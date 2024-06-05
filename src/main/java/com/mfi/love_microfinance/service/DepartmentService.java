package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartment(){
        return  departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id){
        return  departmentRepository.findById(id).orElse(null);
    }

    public  Department createDepartment(Department department){
        return  departmentRepository.save(department);
    }

    public  Department updateDepartment(Integer id, Department departmentDetails){
        Department department=departmentRepository.findById(id).orElse(null);
        if(department!=null){
            department.setName(departmentDetails.getName());
            department.setStuffs(departmentDetails.getStuffs());
            return  departmentRepository.save(department);
        }
        return  null;
    }

    public  void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }
}
