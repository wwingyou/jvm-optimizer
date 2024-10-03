package com.example.tester_v2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tester_v2.annotation.CustomTest;
import com.example.tester_v2.entity.Department;

/**
 * DepartmentRepositoryTest
 */
@CustomTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Test
    void new_department() {
        // Given
        final String depNumber = "d009";
        Department department = Department.builder()
                .number(depNumber)
                .name("Customer Service")
                .build();

        // When
        Department savedDepartment = repository.save(department);
        Department foundDepartment = repository.findById(depNumber).orElse(null);

        // Then
        assertThat(foundDepartment).isNotNull()
                                   .isEqualTo(savedDepartment);
    }
}
