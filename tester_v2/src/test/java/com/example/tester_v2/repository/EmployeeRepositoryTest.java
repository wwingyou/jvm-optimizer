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
import com.example.tester_v2.entity.Salary;
import com.example.tester_v2.entity.Title;
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
        Title title = Title.builder()
                .title("Senior Engineer")
                .fromDate(LocalDate.of(1986, 6, 26))
                .toDate(LocalDate.of(9999, 1, 1))
                .build();
        Salary salary = Salary.builder()
                .salary(60117)
                .fromDate(LocalDate.of(1986, 6, 26))
                .toDate(LocalDate.of(1987, 6, 26))
                .build();
        Employee employee = Employee.builder()
                .employeeNumber(10001)
                .birthDate(LocalDate.of(1953, 9, 2))
                .firstName("Georgi")
                .lastName("Facello")
                .gender(Gender.M)
                .hireDate(LocalDate.of(1986, 6, 26))
                .build();
        title.setEmployee(employee);
        salary.setEmployee(employee);
        log.info("== Given complete ==");

        // When
        Employee savedEmployee = repository.save(employee);
        log.info("== save complete ==");
        Employee foundEmployee = repository.findById(10001).orElse(null);
        log.info("== When complete ==");

        // Then
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.equals(savedEmployee));
        assertThat(foundEmployee.getSalaries().contains(salary));
        assertThat(foundEmployee.getTitles().contains(title));

        entityManager.flush();
        log.info("== Then complete ==");
    }

}
