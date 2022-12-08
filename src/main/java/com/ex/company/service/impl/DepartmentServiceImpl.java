package com.ex.company.service.impl;

import com.ex.company.entity.Department;
import com.ex.company.rpository.DepartmentRepository;
import com.ex.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Long id,Department department){
        Department departmentEntity = departmentRepository.findById(id).get();
        departmentEntity.setName(department.getName());
        departmentRepository.save(departmentEntity);
    }

}
