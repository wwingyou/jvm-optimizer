package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * TitleForm
 */
@Data
@Builder
public class TitleForm {

    private Integer employeeNumber;
    private String title;
    private LocalDate fromDate;
    private LocalDate toDate;

}
