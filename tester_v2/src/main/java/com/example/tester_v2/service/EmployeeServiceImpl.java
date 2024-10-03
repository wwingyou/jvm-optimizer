package com.example.tester_v2.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tester_v2.dto.EmployeeForm;
import com.example.tester_v2.dto.EmployeeView;
import com.example.tester_v2.dto.SalaryForm;
import com.example.tester_v2.dto.TitleForm;

/**
 * EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void createEmployee(EmployeeForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");
    }

    @Override
    public void updateEmployee(EmployeeForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void deleteEmployee(Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

    @Override
    public EmployeeView getEmployeeByNumber(Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeByNumber'");
    }

    @Override
    public Page<EmployeeView> getEmployees(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployees'");
    }

    @Override
    public void setTitle(Integer employeeNumber, TitleForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

    @Override
    public void updateTitle(Integer employeeNumber, String title, LocalDate fromDate, TitleForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTitle'");
    }

    @Override
    public void deleteTitle(Integer employeeNumber, String title, LocalDate fromDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTitle'");
    }

    @Override
    public void setSalary(Integer employeeNumber, SalaryForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSalary'");
    }

    @Override
    public void updateSalary(Integer employeeNumber, LocalDate fromDate, SalaryForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSalary'");
    }

    @Override
    public void deleteSalary(Integer employeeNumber, LocalDate fromDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSalary'");
    }

    
}
