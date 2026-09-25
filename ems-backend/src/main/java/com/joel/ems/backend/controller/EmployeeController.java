package com.joel.ems.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joel.ems.backend.dto.EmployeeDto;
import com.joel.ems.backend.service.EmployeeService;


import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    // Build Add Employee REST API
    @PostMapping 
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new  ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
