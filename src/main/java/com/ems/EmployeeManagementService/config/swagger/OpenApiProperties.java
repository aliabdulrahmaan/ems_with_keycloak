package com.ems.EmployeeManagementService.config.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "openapi")
//@ConstructorBinding
//@AllArgsConstructor
@Getter
//@Configuration
@Component
public class OpenApiProperties {

    private  String projectTitle;
    private  String projectDescription;
    private  String projectVersion;
}