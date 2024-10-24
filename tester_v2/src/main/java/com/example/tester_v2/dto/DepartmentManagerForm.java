package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * DepartmentManagerForm
 */
@Data
@Builder
public class DepartmentManagerForm {

    private Integer employeeNumber;
    private LocalDate fromDate;
    private LocalDate toDate;

}

