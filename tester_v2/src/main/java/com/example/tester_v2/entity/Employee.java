package com.example.tester_v2.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Employee
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "employeeNumber" })
@Table(name = "employees")
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

    @OneToMany(mappedBy = "manager", cascade = CascadeType.REMOVE)
    @Builder.Default
    private Set<DepartmentManager> managingDepartment = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @Builder.Default
    private Set<DepartmentEmployee> engagingDepartment = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Title> titles = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Salary> salaries = new HashSet<>();

}
