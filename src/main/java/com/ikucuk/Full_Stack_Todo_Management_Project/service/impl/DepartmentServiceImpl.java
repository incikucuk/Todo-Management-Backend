package com.ikucuk.Full_Stack_Todo_Management_Project.service.impl;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.DepartmentDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Department;
import com.ikucuk.Full_Stack_Todo_Management_Project.exception.ResourceNotFoundException;
import com.ikucuk.Full_Stack_Todo_Management_Project.mapper.DepartmentMapper;
import com.ikucuk.Full_Stack_Todo_Management_Project.repository.DepartmentRepository;
import com.ikucuk.Full_Stack_Todo_Management_Project.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartmentEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment) ;
    }

    @Override
    public DepartmentDto getDepartmentsById(long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: "+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departmentList= departmentRepository.findAll();
        return departmentList.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: "+departmentId));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());

        departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartmentById(long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: "+id));
       departmentRepository.deleteById(id);
    }
}
