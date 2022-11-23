package com.ems.EmployeeManagementService.controllers.searchcriteria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeFilter {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Long departmentId;
}
