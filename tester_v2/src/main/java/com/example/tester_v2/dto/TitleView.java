package com.example.tester_v2.dto;

import java.time.LocalDate;

import com.example.tester_v2.entity.Title;

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

    public static TitleView of (Title title) {
        return TitleView.builder()
                .title(title.getTitle())
                .fromDate(title.getFromDate())
                .toDate(title.getToDate())
                .build();
    }
}
