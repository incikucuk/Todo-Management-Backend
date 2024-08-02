package com.ikucuk.Full_Stack_Todo_Management_Project.mapper;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.EmployeeDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
