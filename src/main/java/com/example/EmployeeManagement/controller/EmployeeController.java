package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.dto.EmployeeTaxDto;
import com.example.EmployeeManagement.forms.EmployeeForm;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeForm employeeForm) {
        return ResponseEntity.ok(
                employeeService.addEmployee(employeeForm)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeTaxDto>> getEmployeesTaxDetails() {
        return ResponseEntity.ok(
                employeeService.calculateTaxForEmployees()
        );
    }

}
