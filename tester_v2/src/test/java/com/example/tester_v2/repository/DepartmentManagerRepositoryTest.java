package com.example.tester_v2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tester_v2.annotation.CustomTest;
import com.example.tester_v2.entity.Department;
import com.example.tester_v2.entity.DepartmentManager;
import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.etc.Gender;

/**
 * DepartmentManagerRepositoryTest
 */
@CustomTest
public class DepartmentManagerRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentManagerRepository departmentManagerRepository;

    @Test
    void new_department_manager() {
        // Given
        Department department = Department.builder()
                .number("d009")
                .name("Customer Service")
                .build();
        Employee employee = Employee.builder()
                .employeeNumber(10001)
                .birthDate(LocalDate.of(1953, 9, 2))
                .firstName("Georgi")
                .lastName("Facello")
                .gender(Gender.M)
                .hireDate(LocalDate.of(1986, 6, 26))
                .build();
        DepartmentManager departmentManager = DepartmentManager.builder()
                .fromDate(LocalDate.of(1985, 1, 1))
                .toDate(LocalDate.of(1991, 10, 1))
                .build();
        departmentRepository.save(department);
        employeeRepository.save(employee);

        // When
        departmentManager.setManager(employee);
        departmentManager.setDepartment(department);
        DepartmentManager savedDepartmentManager = departmentManagerRepository.save(departmentManager);
        DepartmentManager foundDepartmentManager = departmentManagerRepository.findById(new DepartmentManager.PK(employee.getEmployeeNumber(), department.getNumber())).orElse(null);

        // Then
        assertThat(foundDepartmentManager).isNotNull()
                                          .isEqualTo(savedDepartmentManager);
    }
}
