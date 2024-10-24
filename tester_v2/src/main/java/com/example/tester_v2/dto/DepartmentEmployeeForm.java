package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * DepartmentEmployeeForm
 */
@Data
@Builder
public class DepartmentEmployeeForm {

    private Integer employeeNumber;
    private LocalDate fromDate;
    private LocalDate toDate;

}
