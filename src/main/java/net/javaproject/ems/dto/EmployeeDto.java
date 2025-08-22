package net.javaproject.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaproject.ems.entity.Employee;


//use this class to transfer the data between client and server
// when we build restful services convert employee to jpa vice versa
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(Employee employee) {
    }
}
//It is just like a card have information of employee