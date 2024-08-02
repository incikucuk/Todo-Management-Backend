package com.ikucuk.Full_Stack_Todo_Management_Project.repository;

import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
