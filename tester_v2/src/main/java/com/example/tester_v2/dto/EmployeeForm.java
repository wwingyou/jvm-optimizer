package com.example.tester_v2.dto;

import java.time.LocalDate;

import com.example.tester_v2.etc.Gender;

import lombok.Builder;
import lombok.Data;

/**
 * EmployeeForm
 */
@Data
@Builder
public class EmployeeForm {

    private Integer employeeNumber;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;

}
