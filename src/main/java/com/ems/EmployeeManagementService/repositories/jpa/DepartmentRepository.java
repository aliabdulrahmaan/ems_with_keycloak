package com.ems.EmployeeManagementService.repositories.jpa;


import com.ems.EmployeeManagementService.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
