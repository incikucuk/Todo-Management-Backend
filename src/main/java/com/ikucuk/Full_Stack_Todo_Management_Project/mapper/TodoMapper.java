package com.ikucuk.Full_Stack_Todo_Management_Project.mapper;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.TodoDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Todo;

public class TodoMapper {
    public static TodoDto mapToTodoDto(Todo todo){
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }

    public static Todo mapToTodoEntity(TodoDto todoDto) {
        return new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.isCompleted()
        );
    }
}
