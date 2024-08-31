package com.ikucuk.Full_Stack_Todo_Management_Project.repository;

import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
