package com.ikucuk.Full_Stack_Todo_Management_Project.service;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentsById(long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(long departmentId, DepartmentDto departmentDto);

    void deleteDepartmentById(long id);
}
