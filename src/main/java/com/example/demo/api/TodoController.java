package com.example.demo.api;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        System.out.println("Fetching todos ");
        List<Todo>  todoList =todoService.getAllTodos();
        System.out.println("returning   "+ todoList.size()+" todos");
        return todoList;

    }

    @PostMapping
    public Todo insertTodo(@RequestBody Todo todoToSave){
        return todoService.insertTodo(todoToSave);
    }


    @DeleteMapping
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public String deleteTodo( @PathVariable("id") int id){

        if (todoService.getTodoBytodoID(id).size()<=0){
            return "No todos found with id "+id+" to delete";
        }

        return todoService.removeByID(id) +" record(s) deleted";
    }

    @GetMapping
    @RequestMapping(value="/{todoid}",method = RequestMethod.GET)
    public List<Todo> getTodoID(@PathVariable("todoid") int id){

        System.out.println("Returning "+todoService.getTodoBytodoID(id).size()+" todos ");

        return todoService.getTodoBytodoID(id);

    }

    @RequestMapping(value="/{todoid}",method = RequestMethod.PUT)
    public String updateTodo(@RequestBody Todo todo){
        int resultNo=todoService.UpdateTodoItem(todo);
        if (resultNo==-1) return "No todo found with given id";
        return "Updated todo with given id";



    }





}
