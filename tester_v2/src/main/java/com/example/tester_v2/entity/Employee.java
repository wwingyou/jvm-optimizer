package com.example.tester_v2.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.tester_v2.etc.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Employee
 */
@Entity
@Getter
@Table(name = "employees")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer employeeNumber;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @OneToMany(mappedBy = "manager")
    private Set<DepartmentManager> managingDepartment;

    @OneToMany(mappedBy = "employee")
    private Set<DepartmentEmployee> engagingDepartment;

    @OneToMany(mappedBy = "employee")
    private Set<Title> titles;

    @OneToMany(mappedBy = "employee")
    private Set<Salary> salaries;

}
