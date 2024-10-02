package com.example.tester_v2.entity;

import java.time.LocalDate;

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
 * Salary
 */
@Entity
@Getter
@IdClass(Salary.PK.class)
@Table(name = "salaries")
public class Salary {

    @Id
    @Column(name = "emp_no")
    private Integer employeeNumber;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    /**
     * PK class of Salary
     */
    public static record PK(Integer employeeNumber, LocalDate fromDate) {}

}

