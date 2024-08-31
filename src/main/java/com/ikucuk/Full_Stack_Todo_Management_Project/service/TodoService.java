package com.ikucuk.Full_Stack_Todo_Management_Project.service;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.TodoDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto,Long id);

    void deleteTodo(long id);

    TodoDto completeTodo(Long id);

    TodoDto inCompleteTodo(Long id);
}
