package com.example.tester_v2.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tester_v2.dto.EmployeeForm;
import com.example.tester_v2.dto.EmployeeView;
import com.example.tester_v2.dto.SalaryForm;
import com.example.tester_v2.dto.TitleForm;
import com.example.tester_v2.entity.Employee;
import com.example.tester_v2.entity.Salary;
import com.example.tester_v2.entity.Title;
import com.example.tester_v2.repository.EmployeeRepository;
import com.example.tester_v2.repository.SalaryRepository;
import com.example.tester_v2.repository.TitleRepository;

import lombok.AllArgsConstructor;

/**
 * EmployeeServiceImpl
 */
@Service
@AllArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;
    private final TitleRepository titleRepository;

    @Override
    public void createEmployee(EmployeeForm form) {
        Employee employee = Employee.builder()
                .employeeNumber(form.getEmployeeNumber())
                .birthDate(form.getBirthDate())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .gender(form.getGender())
                .hireDate(form.getHireDate())
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeForm form) {
        var employee = getEmployee(form.getEmployeeNumber());
        employee.setBirthDate(form.getBirthDate());
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setGender(form.getGender());
        employee.setHireDate(form.getHireDate());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeView getEmployeeByNumber(Integer employeeNumber) {
        var employee = getEmployee(employeeNumber);
        return EmployeeView.of(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeView> getEmployees(Pageable pageable) {
        var employees = employeeRepository.findAll(pageable);
        return employees.map(EmployeeView::of);
    }

    @Override
    public void setTitle(Integer employeeNumber, TitleForm form) {
        var employee = getEmployee(employeeNumber);
        var title = Title.builder()
                .title(form.getTitle())
                .fromDate(form.getFromDate())
                .toDate(form.getToDate())
                .employee(employee)
                .build();
        titleRepository.save(title);
    }

    @Override
    public void updateTitle(Integer employeeNumber, String title, LocalDate fromDate, TitleForm form) {
        var update = titleRepository.findById(new Title.PK(employeeNumber, title, fromDate))
                .orElseThrow();
        update.setToDate(form.getToDate());
        titleRepository.save(update);
    }

    @Override
    public void deleteTitle(Integer employeeNumber, String title, LocalDate fromDate) {
        titleRepository.deleteById(new Title.PK(employeeNumber, title, fromDate));
    }

    @Override
    public void setSalary(Integer employeeNumber, SalaryForm form) {
        var employee = getEmployee(employeeNumber);
        var salary = Salary.builder()
                .salary(form.getSalary())
                .fromDate(form.getFromDate())
                .toDate(form.getToDate())
                .employee(employee)
                .build();
        salaryRepository.save(salary);
    }

    @Override
    public void updateSalary(Integer employeeNumber, LocalDate fromDate, SalaryForm form) {
        var salary = salaryRepository.findById(new Salary.PK(employeeNumber, fromDate))
                .orElseThrow();
        salary.setSalary(form.getSalary());
        salary.setToDate(form.getToDate());
        salaryRepository.save(salary);
    }

    @Override
    public void deleteSalary(Integer employeeNumber, LocalDate fromDate) {
        salaryRepository.deleteById(new Salary.PK(employeeNumber, fromDate));
    }

    private Employee getEmployee(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElseThrow();
    }
}
