package com.example.employee.Employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empAddress;
    private String empPhoneNo;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
