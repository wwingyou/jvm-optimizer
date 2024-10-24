package com.example.tester_v2.dto;

import java.time.LocalDate;

import com.example.tester_v2.entity.Salary;

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

    public static SalaryView of(Salary salary) {
        return SalaryView.builder()
                .salary(salary.getSalary())
                .fromDate(salary.getFromDate())
                .toDate(salary.getToDate())
                .build();
    }
}
