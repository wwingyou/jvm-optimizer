package com.example.tester_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tester_v2.entity.DepartmentManager;

/**
 * DepartmentManagerRepository
 */
public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, Integer> {
}
