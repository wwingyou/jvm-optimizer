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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DepartmentManager
 */
@Entity
@Getter
@IdClass(DepartmentManager.PK.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = { "employeeNumber", "departmentNumber" })
@Table(name = "dept_manager")
public class DepartmentManager {

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

    @MapsId("employeeNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no")
    private Employee manager;

    @MapsId("departmentNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_no")
    private Department department;

    public void setManager(Employee manager) {
        this.manager = manager;
        this.employeeNumber = manager.getEmployeeNumber();
        manager.getManagingDepartment().add(this);
    }

    public void setDepartment(Department department) {
        this.department = department;
        this.departmentNumber = department.getNumber();
        department.getManagers().add(this);
    }

    /**
     * PK class of DepartmentManager
     */
    public static record PK(Integer employeeNumber, String departmentNumber) {}

}
