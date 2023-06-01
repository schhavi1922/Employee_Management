package com.example.EmployeeManagement.utils;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.dto.EmployeeTaxDto;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.forms.EmployeeForm;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;

public class EmployeeUtility {


    public Employee formToEntity(EmployeeForm employeeForm){
        Employee employee = new Employee();
        employee.setFirstName(employeeForm.getFirstName());
        employee.setLastName(employeeForm.getLastName());
        employee.setEmail(employeeForm.getEmail());
        employee.setPhoneNumber(employeeForm.getPhoneNumbers());
        employee.setDateOfJoining(employeeForm.getDateOfJoining());
        employee.setSalary(employeeForm.getSalary());
        return employee;
    }

    public EmployeeDto entityToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber((List<Integer>) employee.getPhoneNumber());
        employeeDto.setDateOfJoining(employee.getDateOfJoining());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }

    public EmployeeTaxDto calculateEmployeeTax(Employee employee){
        EmployeeTaxDto employeeTaxDto = new EmployeeTaxDto();
        employeeTaxDto.setEmployeeId(employee.getId());
        employeeTaxDto.setFirstName(employee.getFirstName());
        employeeTaxDto.setLastName(employee.getLastName());
        employeeTaxDto.setSalaryPerYear(calculateTotalSalary(employee.getSalary(), employee.getDateOfJoining()));
        employeeTaxDto.setTaxAmount(calculateTaxAmount(employeeTaxDto.getSalaryPerYear()));
        employeeTaxDto.setCessAmount(calculateCessAmount(employeeTaxDto.getSalaryPerYear()));
        return employeeTaxDto;
    }

    private Long calculateTotalSalary(Long salary, LocalDate dateOfJoining) {
        LocalDate date = LocalDate.of(dateOfJoining.getYear() + 1, Month.MARCH, 31);
        Period period = Period.between(dateOfJoining, date);
        Long salaryForFullMonth = salary * period.getMonths();
        Long salaryforRemainingDays = salary - ((30 - period.getDays()) * (salary/30));
        Long salaryPerYear = salaryForFullMonth + salaryforRemainingDays;
        return salaryPerYear;
    }

    private Long calculateTaxAmount(Long salaryPerYear) {
        Long taxAmount = 0L;
        Long taxable = 0L;
        if(salaryPerYear > 1000000L){
            taxable = salaryPerYear - 1000000L;
            taxAmount = taxAmount + (taxable * 20/100);
            salaryPerYear = salaryPerYear - taxable;

        }
        if(salaryPerYear > 500000 && salaryPerYear <= 1000000){
            taxable = salaryPerYear - 500000;
            taxAmount = taxAmount + (taxable * 10/100);
            salaryPerYear = salaryPerYear - taxable;
        }
        if(salaryPerYear > 250000 && salaryPerYear <= 500000){
            taxable = salaryPerYear - 250000;
            taxAmount = taxAmount + (taxable * 5/100);
            salaryPerYear = salaryPerYear - taxable;
        }
        return taxAmount;
    }
    private Long calculateCessAmount(Long salaryPerYear) {
        Long cessAmount = 0L;
        Long taxable = 0L;
        if(salaryPerYear > 2500000){
            taxable = salaryPerYear - 2500000;
            cessAmount = taxable * 2/100;

        }
        return cessAmount;
    }
}