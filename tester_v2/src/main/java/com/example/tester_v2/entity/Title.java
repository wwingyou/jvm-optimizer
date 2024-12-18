package com.example.tester_v2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Title
 */
@Entity
@Getter
@IdClass(Title.PK.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "employeeNumber", "title", "fromDate" })
@Table(name = "titles")
public class Title {

    @Id
    @Column(name = "emp_no")
    private Integer employeeNumber;

    @Id
    @Column(name = "title", length = 50)
    private String title;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @MapsId("employeeNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    /**
     * PK class of Title
     */
    public static record PK(Integer employeeNumber, String title, LocalDate fromDate) {}

}
