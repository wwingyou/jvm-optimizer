package com.example.tester_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester_v2.entity.Salary;

/**
 * SalaryRepository
 */
public interface SalaryRepository extends JpaRepository<Salary, Salary.PK> {
}
