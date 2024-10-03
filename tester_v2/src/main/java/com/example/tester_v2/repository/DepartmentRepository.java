package com.example.tester_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester_v2.entity.Department;

/**
 * DepartmentRepository
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
