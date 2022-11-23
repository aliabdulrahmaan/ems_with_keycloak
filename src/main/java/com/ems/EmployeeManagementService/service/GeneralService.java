package com.ems.EmployeeManagementService.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GeneralService {
    private ModelMapper modelMapper = new ModelMapper();


    protected <S, T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }


    protected <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }


    public <D, T> Page<D> mapPage(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));

    }
}