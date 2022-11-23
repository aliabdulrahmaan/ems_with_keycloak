package com.ems.EmployeeManagementService.config.security.employee;


import com.ems.EmployeeManagementService.config.security.AuthoritiesConstants;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('"+ AuthoritiesConstants.EMPLOYEE+"')")
public @interface IsEmployee {
}
