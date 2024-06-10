package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.models.DepartmentModel;
import com.mfi.love_microfinance.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    private List<DepartmentModel> getAllDepartment(){
        return  departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public  DepartmentModel getDepartment(@PathVariable Integer id){
        return  departmentService.getDepartmentById(id);
    }

    @PostMapping
    public  Department createDepartment(@RequestBody Department department){
        return  departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public  DepartmentModel updateDepartment(@PathVariable Integer id,@RequestBody DepartmentModel departmentDetails){
        return departmentService.updateDepartment(id,departmentDetails);
    }

    @DeleteMapping("{id}")
    public  void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
    }
}
