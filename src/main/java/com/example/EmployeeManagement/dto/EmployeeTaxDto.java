package com.example.EmployeeManagement.dto;

public class EmployeeTaxDto {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private Long salaryPerYear;

    private Long taxAmount;

    private Long cessAmount;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(Long salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    public Long getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Long getCessAmount() {
        return cessAmount;
    }

    public void setCessAmount(Long cessAmount) {
        this.cessAmount = cessAmount;
    }
}
