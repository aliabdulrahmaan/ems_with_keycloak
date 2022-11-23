package com.ems.EmployeeManagementService.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages
        = "com.ems.EmployeeManagementService.repositories.search")
//@ComponentScan(basePackages = { "com.ems.EmployeeManagementService.repositories.search" })
@EnableJpaRepositories(basePackages = {"com.ems.EmployeeManagementService.repositories.jpa"})

public class ElasticsearchClientConfig {

}
