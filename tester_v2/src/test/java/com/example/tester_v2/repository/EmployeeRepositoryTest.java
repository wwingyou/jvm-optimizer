package com.example.tester_v2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tester_v2.annotation.CustomTest;
import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.etc.Gender;

/**
 * EmployeeRepository
 */
@CustomTest
public class EmployeeRepositoryTest {

    Logger log = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
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
        assertThat(foundEmployee).isNotNull()
                                 .isEqualTo(savedEmployee);
    }

}
