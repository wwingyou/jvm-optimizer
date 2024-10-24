package com.example.tester_v2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tester_v2.dto.DepartmentEmployeeForm;
import com.example.tester_v2.dto.DepartmentForm;
import com.example.tester_v2.dto.DepartmentManagerForm;
import com.example.tester_v2.dto.DepartmentView;
import com.example.tester_v2.entity.Department;
import com.example.tester_v2.entity.DepartmentEmployee;
import com.example.tester_v2.entity.DepartmentManager;
import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.repository.DepartmentEmployeeRepository;
import com.example.tester_v2.repository.DepartmentManagerRepository;
import com.example.tester_v2.repository.DepartmentRepository;
import com.example.tester_v2.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

/**
 * DepartmentServiceImpl
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;
    private final DepartmentManagerRepository departmentManagerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void createDepartment(DepartmentForm form) {
        var department = Department.builder()
                .number(form.getDepartmentNumber())
                .name(form.getDepartmentName())
                .build();
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(DepartmentForm form) {
        var department = getDepartment(form.getDepartmentNumber());
        department.setName(form.getDepartmentName());
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(String departmentNumber) {
        departmentRepository.deleteById(departmentNumber);
    }

    @Override
    public DepartmentView getDepartmentByNumber(String departmentNumber) {
        return DepartmentView.of(getDepartment(departmentNumber));
    }

    @Override
    public Page<DepartmentView> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable).map(DepartmentView::of);
    }

    @Override
    public void setEmployee(String departmentNumber, Integer employeeNumber, DepartmentEmployeeForm form) {
        var department = getDepartment(departmentNumber);
        var employee = getEmployee(employeeNumber);
        var departmentEmployee = DepartmentEmployee.builder()
                .employee(employee)
                .department(department)
                .fromDate(form.getFromDate())
                .toDate(form.getToDate())
                .build();
        departmentEmployeeRepository.save(departmentEmployee);
    }

    @Override
    public void deleteEmployee(String departmentNumber, Integer employeeNumber) {
        departmentEmployeeRepository.deleteById(new DepartmentEmployee.PK(employeeNumber, departmentNumber));
    }

    @Override
    public void setManager(String departmentNumber, Integer employeeNumber, DepartmentManagerForm form) {
        var department = getDepartment(departmentNumber);
        var manager = getEmployee(employeeNumber);
        var departmentEmployee = DepartmentManager.builder()
                .manager(manager)
                .department(department)
                .fromDate(form.getFromDate())
                .toDate(form.getToDate())
                .build();
        departmentManagerRepository.save(departmentEmployee);
    }

    @Override
    public void deleteManager(String departmentNumber, Integer employeeNumber) {
        departmentManagerRepository.deleteById(new DepartmentManager.PK(employeeNumber, departmentNumber));
    }

    private Department getDepartment(String departmentNumber) {
        var department = departmentRepository.findById(departmentNumber)
                .orElseThrow();
        return department;
    }
    private Employee getEmployee(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElseThrow();
    }

}
