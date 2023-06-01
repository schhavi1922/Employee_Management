package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.dto.EmployeeTaxDto;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.forms.EmployeeForm;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.utils.EmployeeUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeUtility employeeUtility;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeUtility employeeUtility) {
        this.employeeRepository = employeeRepository;
        this.employeeUtility = employeeUtility;
    }

    public EmployeeDto addEmployee(EmployeeForm employeeForm){

        Employee employee = employeeUtility.formToEntity(employeeForm);

        return employeeUtility.entityToDto(employeeRepository.save(employee));
    }

    public List<EmployeeTaxDto> calculateTaxForEmployees(){

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeTaxDto> employeeTaxDtoList = new ArrayList<>();
        for (Employee emp : employeeList) {
            employeeTaxDtoList.add(employeeUtility.calculateEmployeeTax(emp));
        }
        return employeeTaxDtoList;
    }
}
