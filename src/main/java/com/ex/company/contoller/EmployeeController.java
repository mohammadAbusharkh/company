package com.ex.company.contoller;


import com.ex.company.entity.Employee;
import com.ex.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping(path = "/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PostMapping(path = "/delete")
    public void deleteEmployee(@RequestParam Long id){
        employeeService.deleteEmployee(id);
    }

    @PostMapping(path = "/update")
    public void updateEmployee(@RequestParam Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
    }

    @PostMapping(path = "/increase")
    public void increaseSalaryOfDepartment(@RequestParam Integer raise, @RequestParam Long id){
        employeeService.increaseSalaryOfDepartment(raise,id);
    }

    @PostMapping(path = "/delete/retired")
    public void increaseSalaryOfDepartment(@RequestParam String year){
        employeeService.deleteRetiredEmployees(year);
    }

    @GetMapping(path = "/count")
    public Integer increaseSalaryOfDepartment(@RequestParam Long id){
        return employeeService.countByDepartmentId(id);
    }
}
