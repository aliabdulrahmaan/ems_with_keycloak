package com.ems.EmployeeManagementService.service;


import com.ems.EmployeeManagementService.controllers.searchcriteria.EmployeeFilter;
import com.ems.EmployeeManagementService.entites.Employee;
import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
import com.ems.EmployeeManagementService.repositories.jpa.EmployeeRepository;
import com.ems.EmployeeManagementService.repositories.search.EmployeeRepositorySearch;
import com.ems.EmployeeManagementService.service.dtos.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;


@Service
@Transactional
@AllArgsConstructor
public class EmployeeService extends GeneralService {
    private static final  String ENTITY_NAME= "Employee";
    private final EmployeeRepository employeeRepository;
    private final EmployeeRepositorySearch employeeRepositorySearch;


    public EmployeeDTO save(EmployeeDTO employeeDTO){
        Employee e =  map(employeeDTO,Employee.class);
        Employee result=employeeRepository.save(e);
        employeeRepositorySearch.save(e);
        return map(result,EmployeeDTO.class);
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(long id){
        Employee e =employeeRepository.findById(id).orElseThrow(()->
                new BadRequestAlertException("There is no employee with this id",ENTITY_NAME,"employeeNotExists"));

        return map(e,EmployeeDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll( int page, int size){

        Pageable paging = PageRequest.of(page, size);

        Page<Employee> employeesPage =employeeRepository.findAll(paging);
        Page<EmployeeDTO> employeeDTOS=mapPage(employeesPage,EmployeeDTO.class);

        return employeeDTOS;
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllBySearchCriteria( int page, int size,EmployeeFilter employeeFilter){

        Pageable paging = PageRequest.of(page, size);
        Specification<Employee> employeeSpecification= new EmployeeSpecification().getEmployeeSpecification(employeeFilter);
        Page<Employee> employeesPage =employeeRepository.findAll(employeeSpecification,paging);
        Page<EmployeeDTO> employeeDTOS=mapPage(employeesPage,EmployeeDTO.class);

        return employeeDTOS;
    }


    @Transactional(readOnly = true)
    public List<EmployeeDTO> search(String query) {

        List<Employee> employees =employeeRepositorySearch.search(query);
        List<EmployeeDTO> employeeDTOS=mapList(employees,EmployeeDTO.class);
        return employeeDTOS;
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> search(String query, int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeesPage =employeeRepositorySearch.search(query, pageable);
        Page<EmployeeDTO> employeeDTOS=mapPage(employeesPage,EmployeeDTO.class);
        return employeeDTOS;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAllByDepartmentId(long department_id){
        List<Employee> employees =employeeRepository.findAllByDepartment_Id(department_id);
        return mapList(employees,EmployeeDTO.class);
    }


    public void deleteById(Long id){
        employeeRepository.deleteById(id);
        employeeRepositorySearch.deleteById(id);
    }


    public class EmployeeSpecification {
        public Specification<Employee> getEmployeeSpecification(EmployeeFilter request) {
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("firstName"), request.getFirstName()));
                }
                if (request.getLastName() != null && !request.getLastName().isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("lastName"), request.getLastName()));
                }
                if (request.getAddress() != null && !request.getAddress().isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("address"), request.getAddress()));
                }

                if (request.getDepartmentId() != null ) {
                    predicates.add(criteriaBuilder.equal(root.get("department").get("id"), request.getDepartmentId()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }

    }
}