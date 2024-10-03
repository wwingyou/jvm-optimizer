package com.example.tester_v2.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * TitleView
 */
@Data
@Builder
public class TitleView {

    private String title;
    private LocalDate fromDate;
    private LocalDate toDate;

}
