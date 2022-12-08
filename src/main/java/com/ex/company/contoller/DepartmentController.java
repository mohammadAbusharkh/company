package com.ex.company.contoller;

import com.ex.company.entity.Department;
import com.ex.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PostMapping(path = "/add")
    public void addDaprtment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @PostMapping(path = "/delete")
    public void deleteDaprtment(@RequestParam Long id){
        departmentService.deleteDepartment(id);
    }

    @PostMapping(path = "/update")
    public void updateDaprtment(@RequestParam Long id, @RequestBody Department department){
        departmentService.updateDepartment(id,department);
    }
}
