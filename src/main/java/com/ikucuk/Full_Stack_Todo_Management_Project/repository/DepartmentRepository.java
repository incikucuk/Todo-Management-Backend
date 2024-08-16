package com.ikucuk.Full_Stack_Todo_Management_Project.repository;

import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
