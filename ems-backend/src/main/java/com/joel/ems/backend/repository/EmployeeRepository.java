package com.joel.ems.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joel.ems.backend.entity.Employee;

public interface EmployeeRepository extends  JpaRepository<Employee, Long>{
    

}
