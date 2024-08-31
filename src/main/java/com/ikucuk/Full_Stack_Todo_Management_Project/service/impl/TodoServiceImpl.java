package com.ikucuk.Full_Stack_Todo_Management_Project.service.impl;

import com.ikucuk.Full_Stack_Todo_Management_Project.dto.TodoDto;
import com.ikucuk.Full_Stack_Todo_Management_Project.entity.Todo;
import com.ikucuk.Full_Stack_Todo_Management_Project.exception.ResourceNotFoundException;
import com.ikucuk.Full_Stack_Todo_Management_Project.mapper.DepartmentMapper;
import com.ikucuk.Full_Stack_Todo_Management_Project.mapper.TodoMapper;
import com.ikucuk.Full_Stack_Todo_Management_Project.repository.TodoRepository;
import com.ikucuk.Full_Stack_Todo_Management_Project.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo convertedTodo = TodoMapper.mapToTodoEntity(todoDto);

        Todo todo = new Todo();
        todo.setTitle(convertedTodo.getTitle());
        todo.setDescription(convertedTodo.getDescription());
        todo.setCompleted(convertedTodo.isCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(savedTodo);
    }

    @Override
    public TodoDto getTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found id :" + id));
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoMapper::mapToTodoDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found id :" + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        return TodoMapper.mapToTodoDto(todoRepository.save(todo));
    }

    @Override
    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found id :" + id));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found id :" + id));
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found id :" + id));
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }
}
