package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * SalaryView
 */
@Data
@Builder
public class SalaryView {

    private Integer salary;
    private LocalDate fromDate;
    private LocalDate toDate;

}
