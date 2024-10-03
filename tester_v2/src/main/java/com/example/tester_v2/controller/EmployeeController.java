package com.example.tester_v2.controller;

import java.time.LocalDate;

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

import com.example.tester_v2.dto.EmployeeForm;
import com.example.tester_v2.dto.EmployeeView;
import com.example.tester_v2.dto.SalaryForm;
import com.example.tester_v2.dto.TitleForm;

/**
 * EmployeeController
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @GetMapping
    public Page<EmployeeView> getEmployees(Pageable pageable) {
        return null;
    }

    @GetMapping("{employeeNumber}")
    public EmployeeView getEmployeeByNumber(
        @PathVariable Integer employeeNumber
    ) {
        return null;
    }

    @PostMapping
    public void createEmployee(@ModelAttribute EmployeeForm form) {
        return;
    }

    @PutMapping("{employeeNumber}")
    public void updateEmployee(
        @PathVariable Integer employeeNumber,
        @ModelAttribute EmployeeForm form
    ) {
        return;
    }

    @DeleteMapping("{employeeNumber}")
    public void deleteEmployee(
        @PathVariable Integer employeeNumber
    ) {
        return;
    }

    @PostMapping("{employeeNumber}/title")
    public void addTitle(
        @PathVariable Integer employeeNumber,
        @ModelAttribute TitleForm form
    ) {
        return;
    }

    @DeleteMapping("{employeeNumber}/title")
    public void deleteTitle(
        @PathVariable Integer employeeNumber,
        @RequestParam String title,
        @RequestParam LocalDate fromDate
    ) {
        return;
    }

    @PostMapping("{employeeNumber}/salary")
    public void addSalary(
        @PathVariable Integer employeeNumber,
        @ModelAttribute SalaryForm form
    ) {
        return;
    }

    @DeleteMapping("{employeeNumber}/salary")
    public void deleteSalary(
        @PathVariable Integer employeeNumber,
        @RequestParam LocalDate fromDate
    ) {
        return;
    }

}
