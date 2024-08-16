package com.example.employee.Employee.controller;

import com.example.employee.Employee.dto.AddEmployeeRequestDto;
import com.example.employee.Employee.model.EmployeeModel;
import com.example.employee.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController
{
    // generate employee service class through the autowired and it injects services
    @Autowired
    private EmployeeService employeeService;

    // post method use to adding employee and call the empService method to add template
    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody AddEmployeeRequestDto addEmployeeRequestDto)
    {
        return employeeService.addEmployee(addEmployeeRequestDto);
    }

    // Get method use to getting employee with emp id
    @GetMapping("/getEmpById/{id}")
    public EmployeeModel geEmployeeById(@PathVariable("id") long id)
    {
        return  employeeService.getEmployeeById(id);
    }

    // Get method use Getting all employees to call the empService method getAllEmployees
    @GetMapping("/allEmp")
    public List<EmployeeModel> getAllEmployees()
    {
        return (List<EmployeeModel>) employeeService.getAllEmployees();
    }

    // Put method use to Update the employee to call the empService method updateEmployee
    @PutMapping("/updateEmp/{id}")
    public String updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable("id") long id)
    {
        return  employeeService.updateEmployee(employeeModel,id);
    }

    // Delete method use to delete Employee to calling empService method deleteEmployee
    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable("id") long id)
    {
        return employeeService.deleteEmployee(id);
    }

}
