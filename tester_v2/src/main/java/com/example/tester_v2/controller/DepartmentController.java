package com.example.tester_v2.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tester_v2.dto.DepartmentEmployeeForm;
import com.example.tester_v2.dto.DepartmentForm;
import com.example.tester_v2.dto.DepartmentManagerForm;
import com.example.tester_v2.dto.DepartmentView;
import com.example.tester_v2.service.DepartmentService;

import lombok.AllArgsConstructor;

/**
 * DepartmentController
 */
@RestController
@RequestMapping("department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public Page<DepartmentView> getDepartments(Pageable pageable) {
        return departmentService.getDepartments(pageable);
    }

    @GetMapping("{departmentNumber}")
    public DepartmentView getDepartmentByNumber(
        @PathVariable String departmentNumber
    ) {
        return departmentService.getDepartmentByNumber(departmentNumber);
    }

    @PostMapping
    public void createDepartment(@ModelAttribute DepartmentForm form) {
        departmentService.createDepartment(form);
    }

    @PutMapping("{departmentNumber}")
    public void updateDepartment(
        @PathVariable String departmentNumber,
        @ModelAttribute DepartmentForm form
    ) {
        departmentService.updateDepartment(form);
    }

    @DeleteMapping("{departmentNumber}")
    public void deleteDepartment(@PathVariable String departmentNumber) {
        departmentService.deleteDepartment(departmentNumber);
    }

    @PostMapping("{departmentNumber}/employee")
    public void setEmployee(
        @PathVariable String departmentNumber,
        @ModelAttribute DepartmentEmployeeForm form
    ) {
        departmentService.setEmployee(departmentNumber, form.getEmployeeNumber(), form);
    }

    @DeleteMapping("{departmentNumber}/employee/{employeeNumber}")
    public void deleteEmployee(
        @PathVariable String departmentNumber,
        @PathVariable Integer employeeNumber
    ) {
        departmentService.deleteEmployee(departmentNumber, employeeNumber);
    }

    @PostMapping("{departmentNumber}/manager")
    public void setManager(
        @PathVariable String departmentNumber,
        @ModelAttribute DepartmentManagerForm form
    ) {
        departmentService.setManager(departmentNumber, form.getEmployeeNumber(), form);
    }

    @DeleteMapping("{departmentNumber}/manager/{employeeNumber}")
    public void deleteManager(
        @PathVariable String departmentNumber,
        @PathVariable Integer employeeNumber
    ) {
        departmentService.deleteManager(departmentNumber, employeeNumber);
    }

}
