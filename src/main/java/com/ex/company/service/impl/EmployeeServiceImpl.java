package com.ex.company.service.impl;

import com.ex.company.entity.Department;
import com.ex.company.entity.Employee;
import com.ex.company.rpository.DepartmentRepository;
import com.ex.company.rpository.EmployeeRepository;
import com.ex.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        employee.setDepartmentId(departmentRepository.findById(employee.getDepartmentId().getId()).get());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(Long id, Employee employee){
        Employee employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setBirtDate(employee.getBirtDate());
        employeeEntity.setDepartmentId(departmentRepository.findById(employee.getDepartmentId().getId()).get());
        employeeEntity.setName(employee.getName());
        employeeEntity.setMsisdn(employee.getMsisdn());
        employeeEntity.setSalary(employee.getSalary());
        employeeRepository.save(employeeEntity);
    }

    public void increaseSalaryOfDepartment(Integer raise, Long department_id){
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentRepository.findById(department_id).get());
        List<Employee> updatedEmployeeList = employeeList.stream().map(employee -> {
            Integer salary = employee.getSalary();
            salary = salary + raise;
            employee.setSalary(salary);
            return employee;
        }).collect(Collectors.toList());
        employeeRepository.saveAll(updatedEmployeeList);
    }

    public void deleteRetiredEmployees(String year){
        List<Employee> employeeList =  employeeRepository.findEmployeeByYear(year);
        employeeRepository.deleteAll(employeeList);
    }

    public Integer countByDepartmentId(Long department_id){
        return employeeRepository.countByDepartmentId(departmentRepository.findById(department_id).get());
    }

}
