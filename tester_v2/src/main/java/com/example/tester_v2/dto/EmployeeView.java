package com.example.tester_v2.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.tester_v2.entity.Employee;
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
    private List<DepartmentView> engagingDepartments;
    private List<DepartmentView> managingDepartments;
    private List<SalaryView> salaries;
    private List<TitleView> titles;

    public static EmployeeView of(Employee employee) {
        return EmployeeView.builder()
                .employeeNumber(employee.getEmployeeNumber())
                .birthDate(employee.getBirthDate())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .hireDate(employee.getHireDate())
                .engagingDepartments(employee.getEngagingDepartment().stream().map(DepartmentView::of).toList())
                .managingDepartments(employee.getManagingDepartment().stream().map(DepartmentView::of).toList())
                .salaries(employee.getSalaries().stream().map(SalaryView::of).toList())
                .titles(employee.getTitles().stream().map(TitleView::of).toList())
                .build();
    }
}
