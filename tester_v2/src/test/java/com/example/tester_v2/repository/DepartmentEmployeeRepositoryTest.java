package com.example.tester_v2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tester_v2.annotation.CustomTest;
import com.example.tester_v2.entity.Department;
import com.example.tester_v2.entity.DepartmentEmployee;
import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.etc.Gender;

/**
 * DepartmentEmployeeRepositoryTest
 */
@CustomTest
public class DepartmentEmployeeRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentEmployeeRepository departmentEmployeeRepository;

    @Test
    void new_department_employee() {
        // Given
        Integer employeeNumber = 10001;
        String departmentNumber = "d009";
        Department department = Department.builder()
                .number(departmentNumber)
                .name("Customer Service")
                .build();
        Employee employee = Employee.builder()
                .employeeNumber(employeeNumber)
                .birthDate(LocalDate.of(1953, 9, 2))
                .firstName("Georgi")
                .lastName("Facello")
                .gender(Gender.M)
                .hireDate(LocalDate.of(1986, 6, 26))
                .build();
        DepartmentEmployee departmentEmployee = DepartmentEmployee.builder()
                .fromDate(LocalDate.of(1985, 1, 1))
                .toDate(LocalDate.of(1991, 10, 1))
                .build();
        departmentRepository.save(department);
        employeeRepository.save(employee);

        // When
        departmentEmployee.setEmployee(employee);
        departmentEmployee.setDepartment(department);
        var pk = new DepartmentEmployee.PK(employeeNumber, departmentNumber);
        DepartmentEmployee savedDepartmentManager = departmentEmployeeRepository.save(departmentEmployee);
        DepartmentEmployee foundDepartmentManager = departmentEmployeeRepository.findById(pk).orElse(null);

        // Then
        assertThat(foundDepartmentManager).isNotNull()
                                          .isEqualTo(savedDepartmentManager);
    }
}

