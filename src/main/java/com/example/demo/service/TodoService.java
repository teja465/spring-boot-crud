package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getAllTodos(){
        return todoRepo.getAllTodos();
    }
    public Todo insertTodo(Todo todo){
        return todoRepo.save(todo);
    }
    public int removeByID(int id){

        return todoRepo.deleteBytodoID(id);
    }

    public List<Todo> getTodoBytodoID(int id){

        return todoRepo.getBytodoID(id);

    }
    public int UpdateTodoItem(Todo todo){
        if (todoRepo.getBytodoID(todo.getTodoID()).size()==0){
            return -1;
        }
        return todoRepo.UpdateTodoItem(todo.getTodoID(),todo.getTodoItem());
    }
}
