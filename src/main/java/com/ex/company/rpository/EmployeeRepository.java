package com.ex.company.rpository;

import com.ex.company.entity.Department;
import com.ex.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByDepartmentId(Department departmentId);
    @Query( value= "SELECT * from (SELECT *, SUBSTRING(birt_date, LENGTH(birt_date)-3) AS year FROM company.employee ) AS retirment WHERE year = ?1 ",
            nativeQuery = true)
    public List<Employee> findEmployeeByYear(String year);
    public Integer countByDepartmentId(Department departmentId);
}
