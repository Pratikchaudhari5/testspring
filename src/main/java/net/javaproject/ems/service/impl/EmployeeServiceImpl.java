package net.javaproject.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaproject.ems.dto.EmployeeDto;
import net.javaproject.ems.entity.Employee;
import net.javaproject.ems.exception.ResourceNotFoundException;
import net.javaproject.ems.mapper.EmployeeMapper;
import net.javaproject.ems.repository.EmployeeRepository;
import net.javaproject.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//It's a special room -> Employee Maker -> create employee


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    //injected repo as dependency
    private EmployeeRepository employeeRepository;

    //create employee method
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //convert dto into entity -> bcoz we need to store entity in db
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        //now save into db
        Employee savedEmployee =   employeeRepository.save(employee);
       //now sent back to client
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // get employee by id method
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
      Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with a given id : " + employeeId));
       //convert employee into dto
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
    List<Employee> employees =    employeeRepository.findAll();
    //below is logic to convert list of jpa into dto
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        //if employee id is not present throw error logic
      Employee employee =   employeeRepository.findById(employeeId).orElseThrow(
                () ->  new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

      //set detail from update employee to employee
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        //save method do both save and update
        //if id exist then update else insert -> save work like that
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with a given id : " + employeeId));

        employeeRepository.deleteById(employeeId);
    }
}

//Give employeeDto card, change it to employee card then put it in file cabinet
//again it take that file and change it to EmployeeDto card -> gives to you