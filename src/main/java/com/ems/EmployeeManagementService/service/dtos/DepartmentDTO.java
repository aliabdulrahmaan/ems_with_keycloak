package com.ems.EmployeeManagementService.service.dtos;


import com.ems.EmployeeManagementService.service.GeneralService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@Getter
public class DepartmentDTO  {

    private long id;
    private String name;
}
