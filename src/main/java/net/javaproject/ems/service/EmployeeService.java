package net.javaproject.ems.service;

import net.javaproject.ems.dto.EmployeeDto;

import java.util.List;

//it knows how to add employee

public interface EmployeeService  {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //define get employee method
    EmployeeDto getEmployeeById(Long employeeId);

    //define get all employee method
    List<EmployeeDto> getAllEmployees();

    //define update employee mehtod
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    //define delete employee method
     void deleteEmployee(Long employeeId);
}
