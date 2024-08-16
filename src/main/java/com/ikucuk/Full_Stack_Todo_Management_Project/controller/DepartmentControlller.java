package com.ikucuk.Full_Stack_Todo_Management_Project.controller;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.DepartmentDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentControlller {
    DepartmentService departmentService;

    public DepartmentControlller(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") long id){
        return new ResponseEntity<>(departmentService.getDepartmentsById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") long id,
                                                          @RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.updateDepartment(id,departmentDto),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("Deleted id: "+id,HttpStatus.OK);
    }
}

