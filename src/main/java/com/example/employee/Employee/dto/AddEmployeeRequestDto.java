package com.example.employee.Employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class AddEmployeeRequestDto
{
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empAddress;
    private String empPhoneNo;
}
