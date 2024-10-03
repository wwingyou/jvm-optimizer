package com.example.tester_v2.dto;

import java.time.LocalDate;
import java.util.Set;

import com.example.tester_v2.etc.Gender;

import lombok.Builder;
import lombok.Data;

/**
 * EmployeeView
 */
@Data
@Builder
public class EmployeeView {

    private Integer employeeNumber;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;
    private Set<DepartmentView> engagingDepartments;
    private Set<DepartmentView> managingDepartments;
    private Set<SalaryView> salaries;
    private Set<TitleView> titles;

}
