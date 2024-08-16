package com.example.employee.Employee.service;

import com.example.employee.Employee.dto.AddEmployeeRequestDto;
import com.example.employee.Employee.messageConfig.MessegeConf;
import com.example.employee.Employee.model.EmployeeModel;
import com.example.employee.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService
{
    // using autowired to injects the object of Employeerepo and thorugh access the CRUD operation.
    @Autowired
    EmployeeRepository employeeRepository;

    // addEmployee method is used to add the data into database.
    public String addEmployee(AddEmployeeRequestDto addEmployeeRequestDto)
    {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmpFirstName(addEmployeeRequestDto.getEmpFirstName());
        employeeModel.setEmpLastName(addEmployeeRequestDto.getEmpLastName());
        employeeModel.setEmpEmail(addEmployeeRequestDto.getEmpEmail());
        employeeModel.setEmpAddress(addEmployeeRequestDto.getEmpAddress());
        employeeModel.setEmpPhoneNo(addEmployeeRequestDto.getEmpPhoneNo());
        employeeModel.setCreatedDate(LocalDateTime.now());
        employeeModel.setActive(true);
        employeeModel.setUpdatedDate(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return MessegeConf.SUCCESS_ADDED_EMP;
    }

    // getEmployee with passing id into getEmployeeById method, and it will get emp from database.
    public EmployeeModel getEmployeeById(long id)
    {
        return employeeRepository.findById(id).get();
    }

    // calling getAllEmployees method to get all employees from the database
    public List<EmployeeModel> getAllEmployees()
    {
        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    // calling updateEmployees method with passing particular emp id to update employee details
    public String updateEmployee(EmployeeModel employeeModel, long id)
    {
        EmployeeModel updateEmp = employeeRepository.findById(id).get();
        if ( updateEmp.getEmpId() >0 && updateEmp.getEmpId()==id)
        {
            updateEmp.setEmpFirstName(employeeModel.getEmpFirstName());
            updateEmp.setEmpLastName(employeeModel.getEmpLastName());
            updateEmp.setEmpEmail(employeeModel.getEmpEmail());
            updateEmp.setEmpAddress(employeeModel.getEmpAddress());
            updateEmp.setEmpPhoneNo(employeeModel.getEmpPhoneNo());
            updateEmp.setUpdatedDate(LocalDateTime.now());
            employeeRepository.save(updateEmp);
            return MessegeConf.SUCCESS_UPDATE_EMP;
        }
        return MessegeConf.ERROR_UPDATE_EMP+" with this :"+id;
    }

    // calling deleteEmployee method to deleteEmployee from the database
    public String deleteEmployee(long id)
    {
        EmployeeModel employeeModel= employeeRepository.findById(id).get();
        employeeRepository.delete(employeeModel);
        return MessegeConf.SUCCESS_DELETE_EMP;
    }
}
