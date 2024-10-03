package com.example.tester_v2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tester_v2.dto.DepartmentForm;
import com.example.tester_v2.dto.DepartmentView;

/**
 * DepartmentService
 */
public interface DepartmentService {

    void createDepartment(DepartmentForm form);
    void updateDepartment(DepartmentForm form);
    void deleteDepartment(String departmentNumber);
    DepartmentView getDepartmentByNumber(String departmentNumber);
    Page<DepartmentView> getDepartments(Pageable pageable);

    void setEmployee(String departmentNumber, Integer employeeNumber);
    void deleteEmployee(String departmentNumber, Integer employeeNumber);
    void setManager(String departmentNumber, Integer employeeNumber);
    void deleteManager(String departmentNumber, Integer employeeNumber);

}
