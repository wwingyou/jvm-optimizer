package com.example.tester_v2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.etc.Gender;

/**
 * EmployeeRepository
 */
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    void new_employee() {
        // Given
        Employee employee = Employee.builder()
                .employeeNumber(10001)
                .birthDate(LocalDate.of(1953, 9, 2))
                .firstName("Georgi")
                .lastName("Facello")
                .gender(Gender.M)
                .hireDate(LocalDate.of(1986, 6, 26))
                .build();

        // When
        Employee savedEmployee = repository.save(employee);
        Employee foundEmployee = repository.findById(10001).orElse(null);

        // Then
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.equals(savedEmployee));
    }
}
