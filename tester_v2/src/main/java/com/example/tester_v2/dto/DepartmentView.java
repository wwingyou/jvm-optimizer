package com.example.tester_v2.dto;

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

}
