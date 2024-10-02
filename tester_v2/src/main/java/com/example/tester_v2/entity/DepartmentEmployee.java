package com.example.tester_v2.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.Getter;

/**
 * DepartmentManager
 */
@Entity
@Getter
@IdClass(DepartmentEmployee.PK.class)
@Table(name = "dept_emp")
public class DepartmentEmployee {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer employeeNumber;

    @Id
    @Column(name = "dept_no", nullable = false, columnDefinition = "char(4)")
    private String departmentNumber;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dept_no")
    private Department department;

    /**
     * PK class of DepartmentEmployee
     */
    public static record PK(Integer employeeNumber, String departmentNumber) {}

}

