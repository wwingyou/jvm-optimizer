package com.example.tester_v2.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tester_v2.dto.EmployeeForm;
import com.example.tester_v2.dto.EmployeeView;
import com.example.tester_v2.dto.SalaryForm;
import com.example.tester_v2.dto.TitleForm;

/**
 * EmployeeService
 */
public interface EmployeeService {

    void createEmployee(EmployeeForm form);
    void updateEmployee(EmployeeForm form);
    void deleteEmployee(Integer employeeNumber);
    EmployeeView getEmployeeByNumber(Integer employeeNumber);
    Page<EmployeeView> getEmployees(Pageable pageable);

    void setTitle(Integer employeeNumber, TitleForm form);
    void updateTitle(
        Integer employeeNumber,
        String title,
        LocalDate fromDate,
        TitleForm form
    );
    void deleteTitle(
        Integer employeeNumber,
        String title,
        LocalDate fromDate
    );

    void setSalary(Integer employeeNumber, SalaryForm form);
    void updateSalary(
        Integer employeeNumber,
        LocalDate fromDate,
        SalaryForm form
    );
    void deleteSalary(
        Integer employeeNumber,
        LocalDate fromDate
    );
}
