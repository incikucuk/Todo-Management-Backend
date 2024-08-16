package com.ikucuk.Full_Stack_Todo_Management_Project.mapper;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.DepartmentDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartmentEntity(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
