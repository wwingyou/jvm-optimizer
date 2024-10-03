package com.example.tester_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester_v2.entity.DepartmentEmployee;

/**
 * DepartmentEmployeeRepository
 */
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, DepartmentEmployee.PK> {
}
