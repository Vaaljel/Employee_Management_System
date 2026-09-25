package com.joel.ems.backend.service.impl;

import org.springframework.stereotype.Service;

import com.joel.ems.backend.dto.EmployeeDto;
import com.joel.ems.backend.entity.Employee;
import com.joel.ems.backend.mapper.EmployeeMapper;
import com.joel.ems.backend.repository.EmployeeRepository;
import com.joel.ems.backend.service.EmployeeService;


import lombok.RequiredArgsConstructor;

@Service  
@RequiredArgsConstructor 
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }    
}
