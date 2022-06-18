package com.example.demo.repository;

import com.example.demo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo,Integer> {


    @Query(value = "select * from todo",nativeQuery = true)
    List<Todo> getAllTodos();

    @Modifying
    @Transactional
    @Query(value = "Delete from todo where id=:id",nativeQuery = true)
    int deleteBytodoID(int id);


    List<Todo> getBytodoID(int id);

    @Modifying
    @Transactional
    @Query(value = "update todo t set t.todoItem=:todoItem where t.id=:id",nativeQuery = true)
    int UpdateTodoItem(int id , String todoItem);

}
