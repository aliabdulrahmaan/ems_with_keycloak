package com.ems.EmployeeManagementService.service.dtos;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class TokenDTO {
    private String accessToken;
    private String refreshToken;
    private Set<String> roles;

}
