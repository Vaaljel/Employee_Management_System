package com.joel.ems.backend.service.impl;

import org.springframework.stereotype.Service;

import com.joel.ems.backend.dto.EmployeeDto;
import com.joel.ems.backend.entity.Employee;
import com.joel.ems.backend.exception.ResourceNotFoundException;
import com.joel.ems.backend.mapper.EmployeeMapper;
import com.joel.ems.backend.repository.EmployeeRepository;
import com.joel.ems.backend.service.EmployeeService;


import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

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
    
    @Override 
    public EmployeeDto getEmployeeById(Long employeeId){
       Employee employee =  employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
            new ResourceNotFoundException("Employee is not exist with given id: " + employeeId)); 
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override 
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> 
        EmployeeMapper.mapToEmployeeDto(employee))
            .collect(Collectors.toList());
    }
}
