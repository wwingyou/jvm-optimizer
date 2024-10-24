package com.example.tester_v2.dto;

import com.example.tester_v2.entity.Department;
import com.example.tester_v2.entity.DepartmentEmployee;
import com.example.tester_v2.entity.DepartmentManager;

import lombok.Builder;
import lombok.Data;

/**
 * DepartmentView
 */
@Data
@Builder
public class DepartmentView {

    private String departmentNumber;
    private String departmentName;

    public static DepartmentView of(Department department) {
        return DepartmentView.builder()
                .departmentNumber(department.getNumber())
                .departmentName(department.getName())
                .build();
    }

    public static DepartmentView of(DepartmentEmployee de) {
        return DepartmentView.of(de.getDepartment());
    }

    public static DepartmentView of(DepartmentManager dm) {
        return DepartmentView.of(dm.getDepartment());
    }
}
