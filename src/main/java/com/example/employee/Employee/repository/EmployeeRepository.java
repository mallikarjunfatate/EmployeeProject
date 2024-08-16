package com.example.employee.Employee.repository;

import com.example.employee.Employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long>
{
}
