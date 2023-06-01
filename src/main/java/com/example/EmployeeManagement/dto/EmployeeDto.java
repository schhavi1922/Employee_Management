package com.example.EmployeeManagement.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class EmployeeDto {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private List<Integer> phoneNumber;

    private LocalDate dateOfJoining;

    private Long salary;

    public EmployeeDto(Long employeeId, String firstName, String lastName, String email, List<Integer> phoneNumber,
                       LocalDate dateOfJoining, Long salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public EmployeeDto() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<Integer> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
