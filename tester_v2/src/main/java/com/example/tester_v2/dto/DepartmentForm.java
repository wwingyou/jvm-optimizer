package com.example.tester_v2.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DepartmentForm
 */
@Data
@Builder
public class DepartmentForm {

    private String departmentNumber;
    private String departmentName;

}
