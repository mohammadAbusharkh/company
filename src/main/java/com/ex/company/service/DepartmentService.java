package com.ex.company.service;

import com.ex.company.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartments();
    public void addDepartment(Department department);
    public void deleteDepartment(Long id);
    public void updateDepartment(Long id, Department department);
}
