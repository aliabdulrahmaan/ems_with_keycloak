package com.ems.EmployeeManagementService.service;


import com.ems.EmployeeManagementService.entites.Department;
import com.ems.EmployeeManagementService.entites.Employee;
import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
import com.ems.EmployeeManagementService.repositories.jpa.DepartmentRepository;
import com.ems.EmployeeManagementService.repositories.search.DepartmentRepositorySearch;
import com.ems.EmployeeManagementService.service.dtos.DepartmentDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentService extends GeneralService {


    private static final  String ENTITY_NAME= "Department";
    private final DepartmentRepository departmentRepository;

    private final DepartmentRepositorySearch departmentRepositorySearch;



    public DepartmentDTO save(DepartmentDTO departmentDTO){
        Department d =  map(departmentDTO,Department.class);
        Department result=departmentRepository.save(d);
        departmentRepositorySearch.save(result);
        return map(result,DepartmentDTO.class);
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findById(long id){
        Department e =departmentRepository.findById(id).orElseThrow(()->
                new BadRequestAlertException("There is no department with this id",ENTITY_NAME,"departmentNotExists"));
        return map(e,DepartmentDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAll(  int page, int size){
        Pageable paging = PageRequest.of(page, size);
        Page<Department> departments =departmentRepository.findAll(paging);
        Page<DepartmentDTO>departmentDTOSPage=mapPage(departments,DepartmentDTO.class);
        return departmentDTOSPage;
    }


    public void deleteById(Long id){
        departmentRepository.deleteById(id);
        departmentRepositorySearch.deleteById(id);
    }



    @Transactional(readOnly = true)
    public List<Department> search(String query) {
        return departmentRepositorySearch.search(query);
    }

    @Transactional(readOnly = true)
    public Page<Department> search(String query, int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        return departmentRepositorySearch.search(query, pageable);
    }




}
