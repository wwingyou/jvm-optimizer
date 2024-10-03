package com.example.tester_v2.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Department
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "dept_no", nullable = false, columnDefinition = "char(4)")
    private String number;

    @Column(name = "dept_name", nullable = false, unique = true, length = 40)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @Builder.Default
    private Set<DepartmentManager> managers = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @Builder.Default
    private Set<DepartmentEmployee> employees = new HashSet<>();

}
