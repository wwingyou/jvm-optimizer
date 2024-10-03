package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * SalaryForm
 */
@Data
@Builder
public class SalaryForm {

    private Integer employeeNumber;
    private Integer salary;
    private LocalDate fromDate;
    private LocalDate toDate;

}
