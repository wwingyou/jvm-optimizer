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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tester_v2.dto.DepartmentForm;
import com.example.tester_v2.dto.DepartmentView;

/**
 * DepartmentController
 */
@RestController
@RequestMapping("department")
public class DepartmentController {

    @GetMapping
    public Page<DepartmentView> getDepartments(Pageable pageable) {
        return null;
    }

    @GetMapping("{departmentNumber}")
    public DepartmentView getDepartmentByNumber(
        @PathVariable String departmentNumber
    ) {
        return null;
    }

    @PostMapping
    public void createDepartment(@ModelAttribute DepartmentForm form) {
        return;
    }

    @PutMapping("{departmentNumber}")
    public void updateDepartment(
        @PathVariable String departmentNumber,
        @ModelAttribute DepartmentForm form
    ) {
        return;
    }

    @DeleteMapping("{departmentNumber}")
    public void deleteDepartment(@PathVariable String departmentNumber) {
        return;
    }

    @PostMapping("{departmentNumber}/employee")
    public void setEmployee(
        @PathVariable String departmentNumber,
        @RequestParam Integer employeeNumber
    ) {
        return;
    }

    @DeleteMapping("{departmentNumber}/employee/{employeeNumber}")
    public void deleteEmployee(
        @PathVariable String departmentNumber,
        @PathVariable Integer employeeNumber
    ) {
        return;
    }

    @PostMapping("{departmentNumber}/manager")
    public void setManager(
        @PathVariable String departmentNumber,
        @RequestParam Integer employeeNumber
    ) {
        return;
    }

    @DeleteMapping("{departmentNumber}/manager/{employeeNumber}")
    public void deleteManager(
        @PathVariable String departmentNumber,
        @PathVariable Integer employeeNumber
    ) {
        return;
    }

}
