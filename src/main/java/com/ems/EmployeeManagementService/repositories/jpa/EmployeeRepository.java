package com.ems.EmployeeManagementService.repositories.jpa;

import com.ems.EmployeeManagementService.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> , JpaSpecificationExecutor<Employee> {


    List<Employee> findAllByDepartment_Id(long department_id);
}
