package com.example.tester_v2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tester_v2.dto.DepartmentForm;
import com.example.tester_v2.dto.DepartmentView;

/**
 * DepartmentServiceImpl
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public void createDepartment(DepartmentForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createDepartment'");
    }

    @Override
    public void updateDepartment(DepartmentForm form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDepartment'");
    }

    @Override
    public void deleteDepartment(String departmentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDepartment'");
    }

    @Override
    public DepartmentView getDepartmentByNumber(String departmentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentByNumber'");
    }

    @Override
    public Page<DepartmentView> getDepartments(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartments'");
    }

    @Override
    public void setEmployee(String departmentNumber, Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmployee'");
    }

    @Override
    public void deleteEmployee(String departmentNumber, Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

    @Override
    public void setManager(String departmentNumber, Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setManager'");
    }

    @Override
    public void deleteManager(String departmentNumber, Integer employeeNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteManager'");
    }

}
