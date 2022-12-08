package com.ex.company.service;

import com.ex.company.entity.Department;
import com.ex.company.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();
    public void addEmployee(Employee employee);
    public void deleteEmployee(Long id);
    public void updateEmployee(Long id, Employee employee);
    public void increaseSalaryOfDepartment(Integer raise, Long department_id);
    public void deleteRetiredEmployees(String year);
    public Integer countByDepartmentId(Long department_id);
}
